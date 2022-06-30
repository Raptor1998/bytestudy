package com.example.thrift.hello.impl;

import com.example.thrift.hello.Hello;
import org.apache.thrift.TException;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @date 2022/6/21 20:39
 * @description
 */
public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        System.out.println("helloString: " + para);
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        System.out.println("helloInt: " + para);
        return para;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        System.out.println("helloBoolean: " + para);
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("helloVoid");
    }

    @Override
    public String helloNull() throws TException {
        System.out.println("helloNull");
        return null;
    }

}
