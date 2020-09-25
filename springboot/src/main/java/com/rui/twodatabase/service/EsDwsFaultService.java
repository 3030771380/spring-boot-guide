package com.rui.twodatabase.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface EsDwsFaultService {
    List<Map<String,Object>> findByCity(String endCounty);

    List<LinkedHashMap<String,Object>> findByCitySql(String endCounty);
}


