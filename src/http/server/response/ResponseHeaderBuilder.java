package http.server.response;

import java.nio.ByteBuffer;

import http.server.bean.Const;
import http.server.bean.Field;
import http.server.request.RequestWrapper;

public class ResponseHeaderBuilder {

    private RequestWrapper request;
    private ResponseWrapper response;

    StringBuffer field = new StringBuffer();

    public ResponseHeaderBuilder(RequestWrapper request, ResponseWrapper response) {
        this.request = request;
        this.response = response;
    }

    public void build() {
        buildReponseHeader();
        response.setResponseHeader(ByteBuffer.wrap(field.toString().getBytes()));
    }

    private void buildReponseHeader() {
        buildReponseLine();
        buildReponseFields();
    }

    private void buildReponseLine() {
        field.append(request.getProtocol());
        field.append(Const.SPACE_SEPARATOR);
        field.append(response.getStatusCode().toString());
        field.append(Const.LINE_SEPARATOR);
    }

    private void buildReponseFields() {
        if (null != response.getAcceptRanges()) {
            field.append(Field.Accept_Ranges.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getAcceptRanges());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getCacheControl()) {
            field.append(Field.Cache_Control.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getCacheControl());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getConnection()) {
            field.append(Field.Connection.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getConnection());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getContentLength()) {
            field.append(Field.Content_Length.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getContentLength());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getContentType()) {
            field.append(Field.Content_Type.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getContentType());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getDate()) {
            field.append(Field.Date.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getDate());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getEtag()) {
            field.append(Field.ETag.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getEtag());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getExpires()) {
            field.append(Field.Expires.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getExpires());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getLastModified()) {
            field.append(Field.Last_Modified.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getLastModified());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getPragma()) {
            field.append(Field.Pragma.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getPragma());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getServer()) {
            field.append(Field.Server.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getServer());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getTransferEncoding()) {
            field.append(Field.Transfer_Encoding.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getTransferEncoding());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getWwwAuthenticate()) {
            field.append(Field.WWW_Authenticate.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getWwwAuthenticate());
            field.append(Const.LINE_SEPARATOR);
        }

        if (null != response.getVary()) {
            field.append(Field.Vary.getName());
            field.append(Const.FIELD_SEPARATOR);
            field.append(response.getVary());
            field.append(Const.LINE_SEPARATOR);
        }

        field.append(Const.LINE_SEPARATOR);
    }

}
