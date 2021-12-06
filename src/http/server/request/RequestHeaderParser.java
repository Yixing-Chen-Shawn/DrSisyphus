package http.server.request;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.Const;
import http.server.bean.Field;

public class RequestHeaderParser {
    private static final Logger LOG = Logger.getLogger(RequestHeaderParser.class.getName());

    private RequestWrapper request;

    public RequestHeaderParser(RequestWrapper request) {
        this.request = request;
    }

    public void parse() {
        ByteBuffer buffer = request.getRequestBuffer();
        String data = new String(buffer.array());
        parseHeader(data);
    }

    private void parseHeader(String data) {
        String[] lines = data.split(Const.LINE_SEPARATOR);

        LOG.log(Level.INFO, "Request parse, line length:" + lines.length);

        if (lines.length < 1) {
            LOG.log(Level.INFO, "Request parse, not data, break.....");
            return;
        }

        parseRequestLine(lines[0]);

        for (int i = 1; i < lines.length; i++) {
            parseHeaderField(lines[i]);
        }

        LOG.log(Level.INFO, "Request parse header ok");
    }

    private void parseRequestLine(String line) {
        String[] fields = line.split(Const.SPACE_SEPARATOR);

        if (fields.length != 3) {
            LOG.log(Level.INFO, "Request parse first line,  Illegal field.....line=" + line);
            return;
        }

        setRequestLine(fields);
    }

    private void setRequestLine(String[] fields) {
        request.setMethod(fields[0]);
        request.setUri(fields[1]);
        request.setProtocol(fields[2]);
    }

    private void parseHeaderField(String line) {
        if ("".equals(line)) {
            return;
        }

        String[] fields = line.split(Const.FIELD_SEPARATOR);

        if (fields.length != 2) {
            LOG.log(Level.INFO, "Request parse field,  Illegal field.....line=" + line);
            return;
        }

        if (null == fields[0] || "".equals(fields[0])) {
            return;
        }

        setHeaderField(fields[0], fields[1]);
    }

    private void setHeaderField(String field, String value) {
        if (Field.Accept.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setAccept(value);
            return;
        }

        if (Field.Accept_Encoding.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setAcceptEncoding(value);
            return;
        }

        if (Field.Accept_Language.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setAcceptLanguage(value);
            return;
        }

        if (Field.Authorization.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setAuthorization(value);
            return;
        }

        if (Field.Cache_Control.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setCacheControl(value);
            return;
        }

        if (Field.Connection.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setConnection(value);
            return;
        }

        if (Field.Referer.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setReferer(value);
            return;
        }

        if (Field.Host.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setHost(value);
            return;
        }

        if (Field.User_Agent.getName().toUpperCase().equals(field.toUpperCase())) {
            request.setUserAgent(value);
            return;
        }

        LOG.log(Level.INFO, "Request parse headed unknown: field=" + field + ", value=" + value);
    }
}
