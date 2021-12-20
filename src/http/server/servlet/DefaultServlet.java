package http.server.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.auth.BasicAuthenticator;
import http.server.bean.Const;
import http.server.bean.Method;
import http.server.bean.StatusCode;
import http.server.request.Request;
import http.server.response.Response;
import http.server.response.ResponseWrapper;
import http.server.util.Util;

public class DefaultServlet extends StaticServlet {
    private static final Logger LOG = Logger.getLogger(DefaultServlet.class.getName());

    //key part of default servlet for handling statis file request
    @Override
    public void service(Request request, Response response) {
        response.setServer(Const.SERVER_NAME);
        if (!BasicAuthenticator.success(request, response)) {
            response.setStatusCode(StatusCode.Unauthorized);
            response.setDate(Util.getGMTString(new Date()));
            response.setWwwAuthenticate("Basic realm=\"Auth\"");
            return;
        }

        if (Method.GET.getName().equals(request.getMethod())) {
            LOG.log(Level.INFO, "doGET...");
            doGet(request, response);
        } else if (Method.POST.getName().equals(request.getMethod())) {
            LOG.log(Level.INFO, "doPOST...");
            doPost(request, response);
        } else {
            LOG.log(Level.INFO, "doNothing");
            doNothing(request, response);
        }
    }

    //for handling requests not supported
    private void doNothing(Request request, Response response) {
        response.setStatusCode(StatusCode.Not_Found);
        response.setDate(Util.getGMTString(new Date()));
    }

    //for handling post request
    private void doPost(Request request, Response response) {
        ResponseWrapper responseWrapper = ((ResponseWrapper) response);
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;

        for (String name : request.getParameters().keySet()) {
            stringBuffer.append("parameter ");
            stringBuffer.append(index++);
            stringBuffer.append(": ");
            stringBuffer.append(name);
            stringBuffer.append("=");
            stringBuffer.append(request.getParameter(name));
            stringBuffer.append("<br>");
        }

        byte[] bytes = stringBuffer.toString().getBytes();
        int len = bytes.length;

        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.put(bytes);
        buffer.flip();
        responseWrapper.setResponseContent(buffer);
        response.setContentLength(len);
        
        response.setStatusCode(StatusCode.OK);
        response.setDate(Util.getGMTString(new Date()));
    }

    //for handling get request
    private void doGet(Request request, Response response) {
        String page = getPage(request);
        File file = new File(page);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Properties properties = new Properties();
        String extension = null;

        response.setServer(Const.SERVER_NAME);

        if (file.exists()) {
            readFile(response, page);

            response.setDate(Util.getGMTString(new Date(file.lastModified())));
            try {
                //check all supported mime type in mime-type file under src folder
                fileReader = new FileReader(Const.MIME_TYPE);
                bufferedReader = new BufferedReader(fileReader);
                properties.load(bufferedReader);
                fileReader.close();
                bufferedReader.close();
                extension = file.getName().split("\\.")[1];
                if (properties.getProperty(extension) == null) {
                    LOG.log(Level.WARNING, "MIME type not found: ", extension);
                    return;
                }
                response.setContentType(properties.getProperty(extension));
            } catch (FileNotFoundException e) {
                LOG.log(Level.WARNING, "Exception: ", e);
            } catch (IOException e) {
                LOG.log(Level.WARNING, "Exception: ", e);
            }
            response.setContentLength((int) file.length());
            response.setStatusCode(StatusCode.OK);
            return;
        }

        response.setStatusCode(StatusCode.Not_Found);
        response.setDate(Util.getGMTString(new Date()));
        ResponseWrapper responseWrapper = ((ResponseWrapper) response);
        byte[] buffer = StatusCode.Not_Found.toString().getBytes();
        responseWrapper.setResponseContent(ByteBuffer.wrap(buffer));
        response.setContentLength(buffer.length);
    }

    private void readFile(Response response, String page) {
        RandomAccessFile randomAccessFile = null;
        ByteBuffer buffer;

        try {
            randomAccessFile = new RandomAccessFile(page, "r");
            int offset = 0;

            int length = (int) randomAccessFile.length();
            buffer = ByteBuffer.allocate(length);

            while (offset < randomAccessFile.length()) {
                byte[] bytes = new byte[Const.DEFAULT_BUFFER_SIZE];
                int len = randomAccessFile.read(bytes);
                buffer.put(bytes, offset, len);
                offset += len;
            }

            ResponseWrapper responseWrapper = ((ResponseWrapper) response);
            buffer.flip();
            responseWrapper.setResponseContent(buffer);
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Read file exception:", e);
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                LOG.log(Level.WARNING, "close file exception: ", e);
            }
        }
    }

    private String getPage(Request request) {
        String page = request.getUri();

        if (null == page) {
            page = Const.DEFAULT_WWWROOT + File.separator + Const.DEFAULT_INDEX_PAGE;
        } else {
            page = Const.DEFAULT_WWWROOT + page;
        }
        return page;
    }

}
