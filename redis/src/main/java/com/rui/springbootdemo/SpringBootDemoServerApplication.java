package com.rui.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableTsf
@ComponentScan(basePackages = {"com.rui.springbootdemo"})
//@MapperScan({"com.rui","com.rui.twodatabase","com.rui.springbootdemo"})
public class SpringBootDemoServerApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringBootDemoServerApplication.class, args);
        }



}
