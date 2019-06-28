package com.wyq.firstdemo.dao;

import com.wyq.firstdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(UserEntity userEntity);

    int insertList(@Param("userEntityList") List<UserEntity> userEntityList);

    int deleteById(int id);

    int update(UserEntity userEntity);

    UserEntity queryById(int id);

    List<UserEntity> queryAll();

}
