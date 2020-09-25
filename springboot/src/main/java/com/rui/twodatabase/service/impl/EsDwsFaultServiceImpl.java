package com.rui.twodatabase.service.impl;

import com.rui.twodatabase.dao.es.EsDwsFaultDMapper;
import com.rui.twodatabase.service.EsDwsFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EsDwsFaultServiceImpl implements EsDwsFaultService {

    @Autowired
    EsDwsFaultDMapper dwsFaultDDao;

    @Override
    public List<Map<String, Object>> findByCity(String endCounty) {
        return dwsFaultDDao.findByCity(endCounty);
    }

    @Override
    public List<LinkedHashMap<String, Object>> findByCitySql(String endCounty) {
        return dwsFaultDDao.findByCitySql(endCounty);
    }
}
