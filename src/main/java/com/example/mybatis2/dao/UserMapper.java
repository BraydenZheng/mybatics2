package com.example.mybatis2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper标识MyBatis的Mapper接口，@MapperScan用于扫描MyBatis的Mapper接口
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByName(@Param("name") String name);

    @Select("select * from mp_user where age > #{age}")
    List<User> selectByAge(Integer age);

//    @Select("select * from mp_user where id = #{age}")
//    List<User> selectById(Long id);
}