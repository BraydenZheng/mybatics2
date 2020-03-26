package com.example.mybatis2.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis2.dao.UserMapper;
import com.example.mybatis2.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //如果插入成功则返回自动生成的主键


//    @Transactional
    @Test
    public void insert(){
        User user = new User();
//        user.setId(1180761990619959297L);
//        user.setName("刘备");
        user.setRemark("这是备注");
        user.setRealName("刘备5");
        user.setAge(25);
        int rows = userMapper.insert(user);
        System.out.println(rows);
        System.out.println(user);
    }

    @Test
    public void selectById(){
        Long id = 1242647023006658562L;
        User user = userMapper.selectById(id);
        System.out.println(user);
    }

    @Test
    public void selectBatchIds(){
//        List<User> users = userMapper.selectBatchIds(null);

//        List<Long> idList = new ArrayList<>();
//        List<User> users = userMapper.selectBatchIds(idList);

        List<Long> idList = new ArrayList<>();
        idList.add(1087982257332887553L);
        idList.add(1088248166370832385L);
        idList.add(1088250446457389058L);
        List<User> users = userMapper.selectBatchIds(idList);
        users.forEach(System.out::println);
    }

    @Test
    public void randomColumnSelect() {
        List<User> user = userMapper.selectList(null);
        for (User u : user) {
            System.out.println(user);
        }
    }
    @Test
    public void selectByNameXML() {
        User user = userMapper.selectByName("刘备");
    }

    @Test
    public void selectByMap(){
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("name", "刘备");
        condition.put("age", 25);
        List<User> users = userMapper.selectByMap(condition);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", 25).likeRight("name", "备");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper =  queryWrapper.inSql("manager_id", "select id from mp_user where name like '%大%' ");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(wq->wq.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id", "realName").like("name", "刘备");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

}