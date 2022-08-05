package com.bytedance.cg.bsm.quickstart.controller;

import org.springframework.stereotype.Service;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/29  16:31
 */
@Service
public class UserService {
    public String getUser(int id){
        return "raptor" + id;
    }
    public int getUserInfo(){
        return 1;
    }
}
