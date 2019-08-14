package com.wyq.firstdemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassName UserEntity
 * @Description 用户实体类
 * @Author weiyanqiang
 * @Date 2019/6/23 22:28
 * @Version 1.0
 */
@Data
public class UserEntity  {

    private int id;

    @Excel(name = "姓名", orderNum = "0")
    @NotBlank(message = "the name can't be blank!")
    private String name;

    @Excel(name = "年龄", orderNum = "1")
    @Min(value = 18, message = "the age can't be younger than {value}!")
    private int age;

    /**
     * 解决json时间格式化的问题
     */
    @Excel(name = "出生日期", orderNum = "2", format = "yyyy-MM-dd HH:mm:ss", width = 20.5)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthDay;

    @Excel(name = "已婚", orderNum = "3", replace = {"否_false","是_true"})
    private boolean married;

    @Excel(name = "年薪", orderNum = "4")
    private float salary;

}
