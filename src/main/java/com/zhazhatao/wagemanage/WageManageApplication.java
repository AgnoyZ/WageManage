package com.zhazhatao.wagemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhazhatao.WageManage.repository"})
public class WageManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WageManageApplication.class, args);
    }

}
