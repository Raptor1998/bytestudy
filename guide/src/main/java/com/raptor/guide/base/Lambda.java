package com.raptor.guide.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/10  17:05
 */
public class Lambda {
    static List<User> users = new ArrayList<>();

    static {
        System.out.println("数据加载。。。");
        users.add(new User(1, "小明", "男"));
        users.add(new User(2, "小李", "男"));
        users.add(new User(2, "晓丽", "女"));
        users.add(new User(4, "小花", "女"));
    }

    @Test
    public void forEach() {
        users.stream().forEach(user -> System.out.println(user));
    }

    @Test
    public void filter() {
        users.stream().filter(user -> user.sex.equals("女")).forEach(user -> System.out.println(user));
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 2, 2, 3, 3);
        list.stream().distinct().forEach(integer -> System.out.println(integer));
    }

    @Test
    public void collectList() {
        List<String> list = users.stream().map(user -> user.userName).collect(Collectors.toList());
        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void collectList2() {
        users.stream().map(user -> {
            if (user.id == 4) {
                user.setUserName("22222");
            }
            return user;
        }).collect(Collectors.toMap(user -> user.id, Function.identity(),(id1,id2)->id1)).forEach((item, val) -> System.out.println(item + " " + val));
    }

    @Test
    public void collectMap() {
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(user -> user.sex));
        System.out.println(collect);

    }
}
