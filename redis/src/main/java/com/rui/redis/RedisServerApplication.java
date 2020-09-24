package com.rui.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableTsf
@ComponentScan(basePackages = {"com.rui.redis"})
public class RedisServerApplication {

    public static void main(String[] args) {
            SpringApplication.run(RedisServerApplication.class, args);
        }



}
