package com.rui.twodatabase.controller;

import com.rui.twodatabase.service.EsDwsFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class EsDataController {

    @Autowired
    EsDwsFaultService esDwsFaultService;

    @RequestMapping("/findByCity")
    List<Map<String,Object>> findByCity(@RequestParam String endCounty){
       return esDwsFaultService.findByCity(endCounty);
    }

    @RequestMapping("/findByCitySql")
    List<LinkedHashMap<String,Object>> findByCitySql(@RequestParam String endCounty){
        return esDwsFaultService.findByCitySql(endCounty);
    }
}
