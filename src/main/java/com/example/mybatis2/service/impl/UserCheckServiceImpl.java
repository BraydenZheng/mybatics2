package com.example.mybatis2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis2.dao.UserMapper;
import com.example.mybatis2.entity.User;
import com.example.mybatis2.service.UserCheckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCheckServiceImpl extends ServiceImpl<UserMapper, User> implements UserCheckService {
    @Override
    public void queryTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getAge, 25);
        List<User> UserList = list(queryWrapper);
        for (User u : UserList)
            System.out.println(u);
    }
}
