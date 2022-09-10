package com.raptor.tomcat.Handler;

import java.io.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/20  17:50
 */
public class HttpResponseHandler {

    private static final String USER_DIR = "user.dir";

    private static final String HTML = "/tomcat/html";

    private static final String NOT_FOUND_ERROR_CODE = "404";
    private static final String SUCCESS_CODE = "200";
    private static final String NOT_FOUND_ERROR_MESSAGE = "404,File not found";
    private OutputStream outputStream;

    public HttpResponseHandler(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void redirect(String uri) {
        String targetUri = System.getProperty(USER_DIR) + HTML + uri;
        File targetFile = new File(targetUri);
        if (!targetFile.exists()) {
            System.out.println(NOT_FOUND_ERROR_CODE);
            try {
                this.outputStream.write(responseBody(NOT_FOUND_ERROR_CODE, NOT_FOUND_ERROR_MESSAGE).getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                System.out.println(SUCCESS_CODE);
                FileInputStream fileInputStream = new FileInputStream(targetFile);
                byte[] bytes = new byte[(int) targetFile.length()];
                fileInputStream.read(bytes);
                String resp = responseBody(SUCCESS_CODE, new String(bytes));
                this.outputStream.write(resp.getBytes());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String responseBody(String code, String message) {
        return "HTTP/1.1 " + code + "\r\n"
                + "Content-type: text/html\r\n"
                + "Content-Length: " + message.length()
                + "\r\n"
                + "\r\n"
                + message;
    }
}
