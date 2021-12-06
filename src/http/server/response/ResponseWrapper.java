package http.server.response;

import java.nio.ByteBuffer;

import http.server.bean.StatusCode;

public class ResponseWrapper implements Response {
    private String acceptRanges;
    private String cacheControl;
    private String connection;
    private int contentLength;
    private String contentType;
    private String date;
    private String etag;
    private String expires;
    private String lastModified;
    private String pragma;
    private String server;
    private StatusCode statusCode;
    private String transferEncoding;
    private String wwwAuthenticate;
    private String vary;

    private ByteBuffer responseHeader;
    private ByteBuffer responseContent;

    public ResponseWrapper() {
    }

    @Override
    public String getAcceptRanges() {
        return acceptRanges;
    }

    @Override
    public void setAcceptRanges(String acceptRanges) {
        this.acceptRanges = acceptRanges;
    }

    @Override
    public String getCacheControl() {
        return cacheControl;
    }

    @Override
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    @Override
    public String getConnection() {
        return connection;
    }

    @Override
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public Integer getContentLength() {
        return contentLength;
    }

    @Override
    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getEtag() {
        return etag;
    }

    @Override
    public void setEtag(String eTag) {
        this.etag = eTag;
    }

    @Override
    public String getExpires() {
        return expires;
    }

    @Override
    public void setExpires(String expires) {
        this.expires = expires;
    }

    @Override
    public String getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String getPragma() {
        return pragma;
    }

    @Override
    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    @Override
    public String getServer() {
        return server;
    }

    @Override
    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public StatusCode getStatusCode() {
        return statusCode;
    }

    @Override
    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getTransferEncoding() {
        return transferEncoding;
    }

    @Override
    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
    }

    @Override
    public String getWwwAuthenticate() {
        return wwwAuthenticate;
    }

    @Override
    public void setWwwAuthenticate(String wwwAuthenticate) {
        this.wwwAuthenticate = wwwAuthenticate;
    }

    @Override
    public String getVary() {
        return vary;
    }

    @Override
    public void setVary(String vary) {
        this.vary = vary;
    }

    ///////////

    @Override
    public ByteBuffer getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ByteBuffer responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public ByteBuffer getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(ByteBuffer responseContent) {
        this.responseContent = responseContent;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        buffer.append((null == getAcceptRanges()) ? "" : ("acceptRanges=" + getAcceptRanges()));
        buffer.append((null == getCacheControl()) ? "" : (" cacheControl=" + getCacheControl()));
        buffer.append((null == getConnection()) ? "" : (" connection=" + getConnection()));
        buffer.append((null == getContentLength()) ? "" : (" contentLength=" + getContentLength()));
        buffer.append((null == getContentType()) ? "" : (" contentType=" + getContentType()));
        buffer.append((null == getDate()) ? "" : (" date=" + getDate()));
        buffer.append((null == getEtag()) ? "" : (" eTag=" + getEtag()));
        buffer.append((null == getExpires()) ? "" : (" expires=" + getExpires()));
        buffer.append((null == getLastModified()) ? "" : (" lastModified=" + getLastModified()));
        buffer.append((null == getPragma()) ? "" : (" pragma=" + getPragma()));
        buffer.append((null == getServer()) ? "" : (" server=" + getServer()));
        buffer.append((null == getStatusCode()) ? "" : (" statusCode=" + getStatusCode()));
        buffer.append((null == getTransferEncoding()) ? "" : (" transferEncoding=" + getTransferEncoding()));
        buffer.append((null == getWwwAuthenticate()) ? "" : (" wwwAuthenticate=" + getWwwAuthenticate()));
        buffer.append((null == getVary()) ? "" : (" vary=" + getVary()));

        buffer.append("]");

        return buffer.toString();
    }

}
