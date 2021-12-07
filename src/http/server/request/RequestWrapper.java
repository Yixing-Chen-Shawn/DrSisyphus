package http.server.request;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class RequestWrapper implements Request {
    private String accept = null;
    private String acceptEncoding = null;
    private String acceptLanguage = null;
    private String authorization = null;
    private String cacheControl = null;
    private String connection = null;
    private String contentType = null;
    private String referer = null;
    private String host = null;
    private String method = null;
    private Map<String, String> parameters = new HashMap<String, String>();
    private String protocol = null;
    private String uri = null;
    private String userAgent = null;

    /////////////////////////
    private ByteBuffer requestBuffer;
    private int requestLength;

    public RequestWrapper(ByteBuffer requestBuffer, int requestLength) {
        this.requestBuffer = requestBuffer;
        this.requestLength = requestLength;
    }

    @Override
    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    @Override
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    @Override
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    @Override
    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    @Override
    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public String getContentType(){
        return contentType;
    }

    public void setContentType(String contentType){
        this.contentType = contentType;
    }

    @Override
    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public void setParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    @Override
    public String getParameter(String key) {
        return this.parameters.get(key);
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    /////////////////////////
    public ByteBuffer getRequestBuffer() {
        return requestBuffer;
    }

    public void setRequestBuffer(ByteBuffer requestBuffer) {
        this.requestBuffer = requestBuffer;
    }

    public int getRequestLength() {
        return requestLength;
    }

    public void setRequestLength(int requestLength) {
        this.requestLength = requestLength;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("[");

        buffer.append((null == getAccept()) ? "" : ("accept=" + getAccept()));
        buffer.append((null == getAcceptEncoding()) ? "" : (" acceptEncoding=" + getAcceptEncoding()));
        buffer.append((null == getAcceptLanguage()) ? "" : (" acceptLanguage=" + getAcceptLanguage()));
        buffer.append((null == getAuthorization()) ? "" : (" authorization=" + getAuthorization()));
        buffer.append((null == getCacheControl()) ? "" : (" cacheControl=" + getCacheControl()));
        buffer.append((null == getConnection()) ? "" : (" connection=" + getConnection()));
        buffer.append((null == getContentType()) ? "" : (" contentType=" + getContentType()));
        buffer.append((null == getReferer()) ? "" : (" referer=" + getReferer()));
        buffer.append((null == getHost()) ? "" : (" host=" + getHost()));
        buffer.append((null == getMethod()) ? "" : (" method=" + getMethod()));
        buffer.append((null == getParameters()) ? "" : (" parameters=" + getParameters()));
        buffer.append((null == getProtocol()) ? "" : (" protocol=" + getProtocol()));
        buffer.append((null == getUri()) ? "" : (" uri=" + getUri()));
        buffer.append((null == getUserAgent()) ? "" : (" userAgent=" + getUserAgent()));

        buffer.append("]");

        return buffer.toString();
    }

}
