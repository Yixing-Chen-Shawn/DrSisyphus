package http.server.task;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.ChannelStatus;
import http.server.request.Request;
import http.server.request.RequestHeaderParser;
import http.server.request.RequestWrapper;
import http.server.response.Response;
import http.server.response.ResponseHeaderBuilder;
import http.server.response.ResponseWrapper;
import http.server.servlet.DefaultServlet;
import http.server.servlet.Servlet;

public class LifeCycle implements Runnable {
    private static final Logger LOG = Logger.getLogger(LifeCycle.class.getName());

    private Request request;
    private RequestHeaderParser requestHeaderParser;
    private Response response;
    private ResponseHeaderBuilder responseHeaderBuilder;
    private Servlet servlet;

    private ChannelStatus channelStatus;

    public LifeCycle() {
        channelStatus = ChannelStatus.Read_Data;
    }

    private void init() {
        requestHeaderParser = new RequestHeaderParser((RequestWrapper) request);
        response = new ResponseWrapper();
        servlet = new DefaultServlet();
        responseHeaderBuilder = new ResponseHeaderBuilder((RequestWrapper) request, (ResponseWrapper) response);
        setChannelStatus(ChannelStatus.Handle_Data);
    }

    @Override
    public void run() {
        init();

        LOG.log(Level.INFO, "LifeCycle started...");

        try {
            // request parser
            requestHeaderParser.parse();
            LOG.log(Level.INFO, "LifeCycle ...request=" + request);


            // application
            // TODO

            // context
            // TODO

            // session
            // TODO

            // filter
            // TODO

            // listener
            // TODO

            // servlet
            servlet.service(request, response);

            // response builder
            responseHeaderBuilder.build();

            //connection status
            setChannelStatus(ChannelStatus.Write_Data);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "LifeCycle exception: ", e);
        }

        LOG.log(Level.INFO, "LifeCycle stoped...");
    }

    public ByteBuffer getResponseHeader() {
        return response.getResponseHeader();
    }

    public ByteBuffer getResponseContent() {
        return response.getResponseContent();
    }

    public void newRequestWrapper(ByteBuffer buffer, int length) {
        request = new RequestWrapper(buffer, length);
    }

    public ChannelStatus getConnectionStatus() {
        return channelStatus;
    }

    public void setChannelStatus(ChannelStatus channelStatus) {
        this.channelStatus = channelStatus;
    }

}
