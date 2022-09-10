package com.raptor.tomcat;

import com.raptor.tomcat.Server.TomcatServer;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/20  17:36
 */
/*
1. 启动socket服务，循环接收请求

2. 接受到请求之后取出数据流

3. 判断目标资源是否存在

4. 资源存在则通过输出流返回，不存在404
 */
public class ServerStarter {
    public static void main(String[] args) {
        System.out.println("server starting......");
        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.receiving();
    }
}
