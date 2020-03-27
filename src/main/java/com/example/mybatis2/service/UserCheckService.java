package com.example.mybatis2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis2.entity.User;

public interface UserCheckService extends IService<User> {
    void queryTest();
}
