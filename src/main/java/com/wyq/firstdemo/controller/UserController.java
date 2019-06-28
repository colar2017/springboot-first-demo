package com.wyq.firstdemo.controller;

import com.wyq.firstdemo.common.ServerResponse;
import com.wyq.firstdemo.entity.UserEntity;
import com.wyq.firstdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description 用户控制类
 * @Author weiyanqiang
 * @Date 2019/6/25 21:41
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public ServerResponse<String> insert(@RequestBody UserEntity userEntity) {
        try {
            userService.insert(userEntity);
        } catch (Exception e) {
            log.error("insert user fail!", e);
            return ServerResponse.createByErrorMessage("insert user fail!");
        }
        return ServerResponse.createBySuccess();
    }

    @PostMapping("/insert/all")
    public ServerResponse<String> insertList(@RequestBody List<UserEntity> userEntityList) {
        try {
            userService.insertList(userEntityList);
        } catch (Exception e) {
            log.error("insert user fail!", e);
            return ServerResponse.createByErrorMessage("insert user fail!");
        }
        return ServerResponse.createBySuccess();
    }

    @DeleteMapping("/delete/{id}")
    public ServerResponse<String> delete(@PathVariable("id") String strId) {
        try {
            int id = Integer.parseInt(strId);
            userService.deleteById(id);
        } catch (NumberFormatException e) {
            log.error("illegal argument!", e);
            return ServerResponse.createByIllegalArgument("illegal argument!");
        } catch (Exception e) {
            log.error("delete user by id fail!", e);
            return ServerResponse.createByErrorMessage("insert user fail!");
        }
        return ServerResponse.createBySuccess();
    }

    @PostMapping("/update")
    public ServerResponse<String> update(@RequestBody UserEntity userEntity) {
        try {
            userService.update(userEntity);
        } catch (Exception e) {
            log.error("update user fail!", e);
            return ServerResponse.createByErrorMessage("update user fail!");
        }
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/list/{id}")
    public ServerResponse<UserEntity> query(@PathVariable("id") String strId) {
        UserEntity userEntity = null;
        try {
            int id = Integer.parseInt(strId);
            userEntity = userService.queryById(id);
        } catch (NumberFormatException e) {
            log.error("illegal argument!",e);
            return ServerResponse.createByIllegalArgument("illegal argument!");
        } catch (Exception e) {
            log.error("query user by id fail!", e);
            return ServerResponse.createByErrorMessage("query user by id fail!");
        }
        return ServerResponse.createBySuccess(userEntity);
    }

    @GetMapping("/list")
    public ServerResponse<List<UserEntity>> queryAll() {
        List<UserEntity> list = null;
        try {
            list = userService.queryAll();
        } catch (Exception e) {
            log.error("query all user fail!", e);
            return ServerResponse.createByErrorMessage("query all user fail!");
        }
        return ServerResponse.createBySuccess(list);
    }

}
