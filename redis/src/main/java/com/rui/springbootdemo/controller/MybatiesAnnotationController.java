package com.rui.springbootdemo.controller;

import com.rui.springbootdemo.entity.Test;
import com.rui.springbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class MybatiesAnnotationController {

    @Autowired
    TestService testService;

    @RequestMapping("/findByVin")
    List<Test> findByVin(@RequestParam String vin){

        return testService.findByVin(vin);
    }

    @RequestMapping("/findByVinMap")
    List<Map<String,Object>> findByVinMap(@RequestParam String vin){

        return testService.findByVinMap(vin);
    }

}
