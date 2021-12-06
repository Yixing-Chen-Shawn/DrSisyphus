package http.server.auth;

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.ConfigField;
import http.server.request.Request;
import http.server.response.Response;

public class BasicAuthenticate {
    private static final Logger LOG = Logger.getLogger(BasicAuthenticate.class.getName());

    public static boolean success(Request request, Response response) {

        if (isAuthorizationSuccess(request)) {
            return true;
        }

        return false;
    }

    private static boolean isAuthorizationSuccess(Request request) {
        if (!ConfigField.Http_Basic.getValue().equals("true")) {
            return true;
        }

        String authorization = request.getAuthorization();

        if (null == authorization) {
            return false;
        }

        LOG.log(Level.INFO, "Request Basic is: " + authorization);

        if (authorization.equals(authorization())) {
            return true;
        }

        return false;

    }

    private static String toBase64(String name, String password) {
        String message = name + ":" + password;
        byte[] encode = Base64.getEncoder().encode(message.getBytes());
        return new String(encode);
    }

    private static String authorization() {
        String basic = "Basic " + toBase64("admin", "admin");
        LOG.log(Level.INFO, "Basic is: " + basic);
        return basic;
    }

}
