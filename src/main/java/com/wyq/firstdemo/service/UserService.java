package com.wyq.firstdemo.service;

import com.wyq.firstdemo.entity.UserEntity;

import java.util.List;

/**
 * 用户服务类
 */
public interface UserService {

    int insert(UserEntity userEntity);

    int insertList(List<UserEntity> userEntityList);

    int deleteById(int id);

    int update(UserEntity userEntity);

    UserEntity queryById(int id);

    List<UserEntity> queryAll();

}
