package com.wyq.firstdemo.service;

import com.wyq.firstdemo.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    void exportUsers(HttpServletResponse response);

    void importUsers(MultipartFile file);
}
