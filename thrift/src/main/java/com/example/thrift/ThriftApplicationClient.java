package com.example.thrift;

import com.example.thrift.hello.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @date 2022/6/21 20:42
 * @description
 */
public class ThriftApplicationClient {
    public static void main(String[] args) {
        try{
            TTransport transport = new TSocket("localhost",9527);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            // 远程调用服务端的helloString方法
            String result = client.helloString("raptor");
            System.out.println(result);
            transport.close();
        }catch (TTransportException e){
            e.printStackTrace();
        }catch (TException e){
            e.printStackTrace();
        }
    }
}
