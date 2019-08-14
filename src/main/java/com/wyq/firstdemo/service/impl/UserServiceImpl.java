package com.wyq.firstdemo.service.impl;

import com.wyq.firstdemo.dao.UserMapper;
import com.wyq.firstdemo.entity.UserEntity;
import com.wyq.firstdemo.service.UserService;
import com.wyq.firstdemo.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author weiyanqiang
 * @Date 2019/6/24 10:14
 * @Version 1.0
 */
@Slf4j
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

    @Override
    public void exportUsers(HttpServletResponse response){
        try {
            List<UserEntity> list = queryAll();
            ExcelUtil.exportExcel(list, "人员信息", "user", UserEntity.class, "users", true, response);
        } catch (IOException e) {
            log.error("导出人员信息出错", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void importUsers(MultipartFile file) {
        try {
            List<UserEntity> list = ExcelUtil.importExcel(file, 1, 1, UserEntity.class);
            insertList(list);
        } catch (IOException e) {
            log.error("导入人员信息出错", e);
            throw new RuntimeException(e);
        }
    }
}
