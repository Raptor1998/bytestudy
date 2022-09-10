package com.raptor.tomcat.Handler;

import java.io.InputStream;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/20  17:38
 */
public class HttpRequestHandler {

    private InputStream inputStream;

    private String uri;

    public HttpRequestHandler(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        byte[] bytes = new byte[1024];
        try {
            inputStream.read(bytes);
            String request = new String(bytes);

            parseUri(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseUri(String request){
        int index1 = request.indexOf(' ');
        int index2 = request.indexOf(' ', index1 + 1);
        this.uri = request.substring(index1+1,index2);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
