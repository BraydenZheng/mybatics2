package com.example.mybatics2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatics2.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
//@Mapper标识MyBatis的Mapper接口，@MapperScan用于扫描MyBatis的Mapper接口
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByName(String name);

    @Select("select * from mp_user where age > #{age}")
    List<User> selectByAge(Integer age);
}