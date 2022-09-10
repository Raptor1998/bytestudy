package com.raptor.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/22  16:09
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("server启动...");
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = inputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,readLen));
            }

            //回复消息
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello client".getBytes());
            socket.shutdownOutput();


            System.out.println("server关闭...");
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
