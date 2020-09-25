package com.rui.es_mysql.service.impl;


import com.rui.es_mysql.dao.master.SignConfigDao;
import com.rui.es_mysql.service.SignConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SignConfigServiceImpl implements SignConfigService {

    @Autowired
    SignConfigDao signConfigDao;

    @Override
    public List<Map<String, Object>> findBySignName(String signName) {
        return signConfigDao.findBSyignName(signName);
    }
}
