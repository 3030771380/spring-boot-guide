package com.rui.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ExceptionTemplateController {

    /**
     * 测试全局空指针异常
     */
    @RequestMapping("/exception")
    public void testException(){
        List list =null;
        list.size();
    }

}
