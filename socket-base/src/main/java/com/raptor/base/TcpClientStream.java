package com.raptor.base;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/22  16:32
 */
public class TcpClientStream {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            System.out.println("客户端启动...");

            OutputStream outputStream = socket.getOutputStream();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder.append("hello ");
            }
//            outputStream.write(stringBuilder.toString().getBytes());

//            socket.shutdownOutput();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("字符流 " + stringBuilder.toString());

            bufferedWriter.newLine();
            bufferedWriter.flush();

            InputStream inputStream = socket.getInputStream();
//            byte[] buf = new byte[1024];
//            int readLen = 0;
//            while ((readLen = inputStream.read(buf)) != -1){
//                System.out.println(new String(buf,0,readLen));
//            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println(s);

            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
            System.out.println("客户端关闭...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
