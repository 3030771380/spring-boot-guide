package com.rui.es_mysql.controller;

import com.rui.es_mysql.dto.ReqDto;
import com.rui.es_mysql.service.SignConfigService;
import com.rui.es_mysql.service.TaskRuleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/restTwo")
public class TowDatabaseController {

    @Autowired
    private SignConfigService signConfigService;
    @Autowired
    private TaskRuleConfigService taskRuleConfigService;

    @RequestMapping("/twoDatabaseMethod")
    public Map<String,Object> twoDatabaseMethod(@RequestBody ReqDto reqDto){
        Map<String,Object> map = new HashMap<>();
        map.put("master", signConfigService.findBySignName(reqDto.getSignName()));
        map.put("slaver",taskRuleConfigService.findByTaskName(reqDto.getTaskCode()));
        return  map;
    }
}
