package com.wyq.firstdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DruidConfig
 * @Description druid参数配置
 * @Author weiyanqiang
 * @Date 2019/6/22 16:49
 * @Version 1.0
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {
    private String username;

    private String password;

    private String logSlowSql;

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
        reg.addInitParameter("logSlowSql", logSlowSql);

        return reg;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
