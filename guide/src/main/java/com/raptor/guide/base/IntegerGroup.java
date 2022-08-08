package com.raptor.guide.base;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/8  20:42
 */
public class IntegerGroup {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);

        Integer c = 3;
        Integer d = 3;
        System.out.println(c == d);

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);
    }
}

