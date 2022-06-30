package com.example.thrift;


import com.example.thrift.hello.Hello;
import com.example.thrift.hello.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftApplicationServer {

    public static void main(String[] args) {
        try{
            // 创建阻塞式socket，绑定端口9527
            TServerSocket serverSocket = new TServerSocket(9527);
            // 将接口实现绑定到process
            TProcessor processor = new Hello.Processor<HelloServiceImpl>(new HelloServiceImpl());
            // 使用二进制协议传输
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverSocket).processor(processor).protocolFactory(factory));
            System.out.println("system server on port 9527...");
            server.serve();
        }catch (TTransportException e){
            e.printStackTrace();
        }
    }

}
