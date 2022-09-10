package com.raptor.tomcat.Server;

import com.raptor.tomcat.Handler.HttpRequestHandler;
import com.raptor.tomcat.Handler.HttpResponseHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/20  17:33
 */
public class TomcatServer {

    private static int PORT = 8080;

    public TomcatServer() {

    }

    public void receiving() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                HttpRequestHandler requestHandler = new HttpRequestHandler(inputStream);
                requestHandler.parse();
                System.out.println("URI: " + requestHandler.getUri());
                OutputStream outputStream = socket.getOutputStream();
                HttpResponseHandler responseHandler = new HttpResponseHandler(outputStream);
                responseHandler.redirect(requestHandler.getUri());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
