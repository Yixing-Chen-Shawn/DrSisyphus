package http.server.bean;

public enum Method {
    // Method Definitions
    OPTIONS("OPTIONS"),
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    TRACE("TRACE"),
    CONNECT("CONNECT"),

    // Additional Request Methods HTTP1.0
    LINK("LINK"),
    UNLINK("UNLINK"),;

    private String name;

    private Method(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
