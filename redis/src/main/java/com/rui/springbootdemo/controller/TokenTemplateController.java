package com.rui.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/token")
@Slf4j
public class TokenTemplateController {

    @RequestMapping("/tokenMethod")
    public void tokenMethod(){
            log.info("登录成功，进首页面");
    }
}
