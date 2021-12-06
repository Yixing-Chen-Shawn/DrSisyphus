package http.server.servlet;

import http.server.request.Request;
import http.server.response.Response;

public interface Servlet {

    void init();

    void service(Request request, Response response);

    void destroy();
    
}
