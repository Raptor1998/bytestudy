package com.raptor.guide.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/10  22:12
 */
@Data
@AllArgsConstructor
class User{
    public int id;
    public String userName;
    public String sex;
}
