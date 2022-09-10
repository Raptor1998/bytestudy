package com.bytedance.cg.bsm.quickstart;

import com.bytedance.cg.bsm.quickstart.controller.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuickStartApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    public void context() {
        System.out.println(userService.getUser(1));
    }

    @Test
    public void context2() {
        int info = userService.getUserInfo();
        if (info == 2){
            throw new RuntimeException("unknown error");
        }
    }
}
