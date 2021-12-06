package http.server.response;

import java.nio.ByteBuffer;

import http.server.bean.StatusCode;

public interface Response {

    String getAcceptRanges();

    void setAcceptRanges(String acceptRanges);

    String getCacheControl();

    void setCacheControl(String cacheControl);

    String getConnection();

    void setConnection(String connection);

    Integer getContentLength();

    void setContentLength(Integer contentLength);

    String getContentType();

    void setContentType(String contentType);

    String getDate();

    void setDate(String date);

    String getEtag();

    void setEtag(String etag);

    String getExpires();

    void setExpires(String expires);

    String getLastModified();

    void setLastModified(String lastModified);

    String getPragma();

    void setPragma(String pragma);

    String getServer();

    void setServer(String server);

    StatusCode getStatusCode();

    void setStatusCode(StatusCode statusCode);

    String getTransferEncoding();

    void setTransferEncoding(String transferEncoding);

    String getWwwAuthenticate();

    void setWwwAuthenticate(String wwwAuthenticate);

    String getVary();

    void setVary(String vary);

    ByteBuffer getResponseHeader();

    ByteBuffer getResponseContent();
}
