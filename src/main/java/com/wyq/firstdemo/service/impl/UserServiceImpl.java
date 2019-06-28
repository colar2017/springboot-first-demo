package com.wyq.firstdemo.service.impl;

import com.wyq.firstdemo.common.ServerResponse;
import com.wyq.firstdemo.dao.UserMapper;
import com.wyq.firstdemo.entity.UserEntity;
import com.wyq.firstdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author weiyanqiang
 * @Date 2019/6/24 10:14
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    @Override
    public int insertList(List<UserEntity> userEntityList) {
        return userMapper.insertList(userEntityList);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(UserEntity userEntity) {
        return userMapper.update(userEntity);
    }

    @Override
    public UserEntity queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<UserEntity> queryAll() {
        return userMapper.queryAll();
    }
}
