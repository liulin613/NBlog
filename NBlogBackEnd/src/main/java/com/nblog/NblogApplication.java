package com.nblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nblog.dao")
@SpringBootApplication
public class NblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NblogApplication.class, args);
    }

}
