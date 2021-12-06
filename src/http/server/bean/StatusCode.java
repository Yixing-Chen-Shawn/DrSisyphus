package http.server.bean;

public enum StatusCode {
    // Informational 1xx
    Continue(100, "Continue"),
    Switching_Protocols(101, "Switching Protocols"),

    // Successful 2xx
    OK(200, "OK"),
    Created(201, "Created"),
    Accepted(202, "Accepted"),
    Non_Authoritative_Information(203, "Non-Authoritative Information"),
    No_Content(204, "No Content"),
    Reset_Content(205, "Reset Content"),
    Partial_Content(206, "Partial Content"),

    // Redirection 3xx
    Multiple_Choices(300, "Multiple Choices"),
    Moved_Permanently(301, "Moved Permanently"),
    Found(302, "Found"), // Moved_Temporarily(302, "Moved Temporarily"),
    See_Other(303, "See Other"),
    Not_Modified(304, "Not Modified"),
    Use_Proxy(305, "Use Proxy"),
    Unused(306, "(Unused)"),
    Temporary_Redirect(307, "Temporary Redirect"),

    // Client Error 4xx
    Bad_Request(400, "Bad Request"),
    Unauthorized(401, "Unauthorized"),
    Payment_Required(402, "Payment Required"),
    Forbidden(403, "Forbidden"),
    Not_Found(404, "Not Found"),
    Method_Not_Allowed(405, "Method Not Allowed"),
    Not_Acceptable(406, "Not Acceptable"),
    Proxy_Authentication_Required(407, "Proxy Authentication Required"),
    Request_Timeout(408, "Request Timeout"),
    Conflict(409, "Conflict"),
    Gone(410, "Gone"),
    Length_Required(411, "Length Required"),
    Precondition_Failed(412, "Precondition Failed"),
    Request_Entity_Too_Large(413, "Request Entity Too Large"),
    Request_URI_Too_Long(414, "Request-URI Too Long"),
    Unsupported_Media_Type(415, "Unsupported Media Type"),
    Requested_Range_Not_Satisfiable(416, "Requested Range Not Satisfiable"),
    Expectation_Failed(417, "Expectation Failed"),

    // Server Error 5xx
    Internal_Server_Error(500, "Internal Server Error"),
    Not_Implemented(501, "Not Implemented"),
    Bad_Gateway(502, "Bad Gateway"),
    Service_Unavailable(503, "Service Unavailable"),
    Gateway_Timeout(504, "Gateway Timeout"),
    HTTP_Version_Not_Supported(505, "HTTP Version Not Supported");

    private int code;
    private String name;

    private StatusCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.code + Const.SPACE_SEPARATOR + this.name;
    }

}
