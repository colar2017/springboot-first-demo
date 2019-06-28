package com.wyq.firstdemo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @ClassName TestDruidConfig
 * @Description TODO
 * @Author weiyanqiang
 * @Date 2019/6/23 17:52
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDruidConfig {

    @Autowired
    private DataSource  dataSource;

    @Test
    public void testDataSource() {
        System.out.println(dataSource.toString());
    }

}
