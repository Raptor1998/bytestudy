package com.raptor.upload;

import com.raptor.util.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/10  10:23
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //写入文件字节流
        String path = "/Users/bytedance/Downloads/image-20220517214218405.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //发送数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        bis.close();
        //写入结束标志
        socket.shutdownOutput();

        //接受消息
        String s = StreamUtils.streamToString(socket.getInputStream());
        System.out.println(s);

        bufferedOutputStream.close();
        socket.close();
    }
}
