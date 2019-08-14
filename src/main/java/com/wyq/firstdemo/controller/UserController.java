package com.wyq.firstdemo.controller;

import com.wyq.firstdemo.common.ServerResponse;
import com.wyq.firstdemo.entity.UserEntity;
import com.wyq.firstdemo.service.UserService;
import com.wyq.firstdemo.util.ListWrapper;
import com.wyq.firstdemo.util.ValidList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    public ServerResponse<String> insert(@Valid @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error(bindingResult.getFieldError().toString());
            return ServerResponse.createByErrorMessage(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.insert(userEntity);
        return ServerResponse.createBySuccess();
    }


    // 使用包装类对list进行验证
/*    @PostMapping("/insert/all")
    public ServerResponse<String> insertList(@Valid @RequestBody ListWrapper<UserEntity> listWrapper, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error(bindingResult.getFieldError().toString());
            return ServerResponse.createByErrorMessage(bindingResult.getFieldError().getDefaultMessage());
        }

        userService.insertList(listWrapper.getList());
        return ServerResponse.createBySuccess();
    }*/


    // 在类上使用@Validated注解，并配合@Valid注解，对list进行验证
/*    @PostMapping("/insert/all")
    public ServerResponse<String> insertList(@Valid @RequestBody List<UserEntity> userEntityList) {
        userService.insertList(userEntityList);
        return ServerResponse.createBySuccess();
    }*/

    // 使用自定义的list，实现list校验
    @PostMapping("/insert/all")
    public ServerResponse<String> insertList(@Valid @RequestBody ValidList<UserEntity> userEntities, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error(bindingResult.getFieldError().toString());
            return ServerResponse.createByErrorMessage(bindingResult.getFieldError().getDefaultMessage());
        }

        userService.insertList(userEntities);
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
        UserEntity userEntity;
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
        List<UserEntity> list;
        try {
            list = userService.queryAll();
        } catch (Exception e) {
            log.error("query all user fail!", e);
            return ServerResponse.createByErrorMessage("query all user fail!");
        }
        return ServerResponse.createBySuccess(list);
    }

    @GetMapping("/export")
    public ServerResponse<String> exportExcel(HttpServletResponse response) {
        userService.exportUsers(response);
        return ServerResponse.createBySuccessMessage("导出成功！");
    }

    @PostMapping("/import")
    public ServerResponse<String> importExcel(@RequestParam("file") MultipartFile file) {
        userService.importUsers(file);
        return ServerResponse.createBySuccessMessage("导入成功！");
    }

}
