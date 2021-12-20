package http.server.auth;

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.ConfigField;
import http.server.request.Request;
import http.server.response.Response;

public class BasicAuthenticator {
    private static final Logger LOG = Logger.getLogger(BasicAuthenticator.class.getName());

    public static boolean success(Request request, Response response) {

        if (isAuthorizationSuccess(request)) {
            return true;
        }

        return false;
    }

    private static boolean isAuthorizationSuccess(Request request) {
        //if the basic authentication is not set to true in the config file
        //dont authenticate at all, let user pass
        if (!ConfigField.Http_Basic.getValue().equals("true")) {
            return true;
        }

        //get authorization header in the request for comparison
        String authorization = request.getAuthorization();

        if (null == authorization) {
            return false;
        }

        LOG.log(Level.INFO, "Request Basic is: " + authorization);

        //authenticated successfully
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

    //convert admin to base64, and compare with the input sent from client side
    private static String authorization() {
        String basic = "Basic " + toBase64("admin", "admin");
        LOG.log(Level.INFO, "Basic is: " + basic);
        return basic;
    }

}
