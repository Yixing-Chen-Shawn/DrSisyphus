package http.server.log;

import java.util.*;

import http.server.bean.*;

public class AccessLog {
    private String ip;
    private Date date;
    private String methodLine;
    private StatusCode statusCode;
    private int length;
    private String userAgent;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethodLine() {
        return methodLine;
    }

    public void setMethodLine(String methodLine) {
        this.methodLine = methodLine;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
