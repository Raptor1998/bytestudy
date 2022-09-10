package com.raptor.util;

import java.io.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/10  10:32
 */
public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len=is.read(b))!=-1){
            bos.write(b,0,len);
        }
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public static String streamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line=bufferedReader.readLine()) != null){
            stringBuilder.append(line + "\r\n");
        }
        return stringBuilder.toString();
    }
}
