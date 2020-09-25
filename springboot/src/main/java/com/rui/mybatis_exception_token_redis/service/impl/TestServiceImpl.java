package com.rui.mybatis_exception_token_redis.service.impl;


import com.rui.mybatis_exception_token_redis.service.TestService;
import com.rui.mybatis_exception_token_redis.dao.TestDao;
import com.rui.mybatis_exception_token_redis.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public List<Test> findByVin(String vin) {

        return testDao.findByVin(vin);
    }

    @Override
    public List<Map<String, Object>> findByVinMap(String vin) {
        return testDao.findByVinMap(vin);
    }
}
