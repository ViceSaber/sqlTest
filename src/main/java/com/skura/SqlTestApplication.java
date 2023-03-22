package com.skura;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.skura.mapper")
@SpringBootApplication
public class SqlTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SqlTestApplication.class, args);
    }

}
