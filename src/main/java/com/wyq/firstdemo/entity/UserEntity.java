package com.wyq.firstdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName UserEntity
 * @Description 用户实体类
 * @Author weiyanqiang
 * @Date 2019/6/23 22:28
 * @Version 1.0
 */
@Getter
@Setter
@ToString
public class UserEntity {

    private int id;

    private String name;

    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthDay;

    private boolean isMarried;

    private float salary;

}
