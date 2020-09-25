package com.rui;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableTsf
@ComponentScan(basePackages = {"com.rui.es_mysql","com.rui.mybatis_exception_token_redis"})
@MapperScan(basePackages = {"com.rui.es_mysql.dao","com.rui.mybatis_exception_token_redis.dao"})
public class SpringBootDemoServerApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringBootDemoServerApplication.class, args);
        }



}
