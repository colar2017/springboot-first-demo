package com.wyq.firstdemo.dao;

import com.wyq.firstdemo.entity.UserEntity;
import com.wyq.firstdemo.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author weiyanqiang
 * @Date 2019/6/24 22:41
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("wyq");
        userEntity.setAge(28);
        userEntity.setBirthDay(DateUtil.strToDateTime("1992-12-28 14:00:00"));
        userEntity.setMarried(true);
        userEntity.setSalary(200000);

        userMapper.insert(userEntity);
    }

    @Test
    public void testInsertList() {
        List<UserEntity> userEntityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("test" + i);
            userEntity.setAge(28 + i);
            userEntity.setBirthDay(DateUtil.strToDateTime("1992-12-28 14:00:00"));
            userEntity.setMarried(true);
            userEntity.setSalary(180000);
            userEntityList.add(userEntity);
        }

        userMapper.insertList(userEntityList);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(2);
        userEntity.setName("fy");
        userEntity.setAge(28);
        userEntity.setBirthDay(DateUtil.strToDateTime("1992-02-03 14:00:00"));
        userEntity.setMarried(true);
        userEntity.setSalary(180000);

        userMapper.update(userEntity);
    }

    @Test
    public void testQueryById() {
        UserEntity userEntity = userMapper.queryById(2);

        System.out.println(userEntity);
    }

    @Test
    public void testQueryAll() {
        List<UserEntity> userEntityList = userMapper.queryAll();

        System.out.println(userEntityList);
    }

}
