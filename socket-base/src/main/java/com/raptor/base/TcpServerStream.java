package com.raptor.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/22  16:31
 */
public class TcpServerStream {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("server启动...");
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

//            byte[] buf = new byte[1024];
//            int readLen = 0;
//            while ((readLen = inputStream.read(buf)) != -1){
//                System.out.println(new String(buf,0,readLen));
//            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println(s);

            //回复消息
            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write("hello client".getBytes());
//            socket.shutdownOutput();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("字符流 hello client");
            bufferedWriter.newLine();
            bufferedWriter.flush();


            System.out.println("server关闭...");
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
