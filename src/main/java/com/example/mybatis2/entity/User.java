package com.example.mybatis2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("mp_user")
public class User implements Serializable {
    @TableId("id")
    private Long userId;
    @TableField("name")
    private String realName;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;

    //不对应表中字段 1.静态字段 2.瞬时字段 3.@TableField(exist = false)
//    private transient String remark;

//    private static String remark;
//    public static String getRemark(){return remark;}
//    public static void setRemark(String remark){
//        User.remark = remark;
//    }

    @TableField(exist = false)
    private String remark;

}