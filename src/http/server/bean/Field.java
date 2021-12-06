package http.server.bean;

public enum Field {
    // Header Field Definitions
    Accept("Accept"),
    Accept_Charset("Accept-Charset"),
    Accept_Encoding("Accept-Encoding"),
    Accept_Language("Accept-Language"),
    Accept_Ranges("Accept-Ranges"),
    Age("Age"),
    Allow("Allow"),
    Authorization("Authorization"),
    Cache_Control("Cache-Control"),
    Connection("Connection"),
    Content_Encoding("Content-Encoding"),
    Content_Language("Content-Language"),
    Content_Length("Content-Length"),
    Content_Location("Content-Location"),
    Content_MD5("Content-MD5"),
    Content_Range("Content-Range"),
    Content_Type("Content-Type"),
    Date("Date"),
    ETag("ETag"),
    Expect("Expect"),
    Expires("Expires"),
    From("From"),
    Host("Host"),
    If_Match("If-Match"),
    If_Modified_Since("If-Modified-Since"),
    If_None_Match("If-None-Match"),
    If_Range("If-Range"),
    If_Unmodified_Since("If-Unmodified-Since"),
    Last_Modified("Last-Modified"),
    Location("Location"),
    Max_Forwards("Max-Forwards"),
    Pragma("Pragma"),
    Proxy_Authenticate("Proxy-Authenticate"),
    Proxy_Authorization("Proxy-Authorization"),
    Range("Range"),
    Referer("Referer"),
    Retry_After("Retry-After"),
    Server("Server"),
    TE("TE"),
    Trailer("Trailer"),
    Transfer_Encoding("Transfer-Encoding"),
    Upgrade("Upgrade"),
    User_Agent("User-Agent"),
    Vary("Vary"),
    Via("Via"),
    Warning("Warning"),
    WWW_Authenticate("WWW-Authenticate"),

    // Additional Header Field Definitions HTTP 1.0
    Link("Link"),
    MIME_Version("MIME-Version"),
    Title("Title"),
    URI("URI");

    private String name;

    private Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
