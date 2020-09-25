package com.rui.twodatabase.service.impl;


import com.rui.twodatabase.dao.master.SignConfigDao;
import com.rui.twodatabase.service.SignConfigService;
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
