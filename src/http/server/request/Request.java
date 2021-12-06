package http.server.request;

import java.util.Map;

public interface Request {

    String getAccept();

    String getAcceptEncoding();

    String getAcceptLanguage();

    String getAuthorization();

    String getCacheControl();

    String getConnection();

    String getReferer();

    String getHost();

    String getMethod();

    Map<String, String> getParameters();

    String getParameter(String key);

    String getUserAgent();

    String getProtocol();

    String getUri();
}
