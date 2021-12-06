package http.server.bean;

public enum ConfigField {
    Https_Port("http.port", "80"),
    Https_Ip("https.ip", "0.0.0.0"),
    Http_Port("http.port", "443"),
    Http_Ip("http.ip", "0.0.0.0"),
    Http_Server_Name("http.server.name", "HttpServer v0.1"),
    Http_Basic("http.basic","true");

    private String name;
    private String value;

    private ConfigField(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
