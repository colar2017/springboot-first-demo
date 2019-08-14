package com.wyq.firstdemo.dao;

import com.wyq.firstdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository这个注解写不写无所谓，不写的话在idea的service中自动注入编译器会报错，但是不影响运行
@Repository
public interface UserMapper {

    int insert(UserEntity userEntity);

    int insertList(@Param("userEntityList") List<UserEntity> userEntityList);

    int deleteById(int id);

    int update(UserEntity userEntity);

    UserEntity queryById(int id);

    List<UserEntity> queryAll();

}
