package com.rui.mybatis_exception_token_redis.service;

import com.rui.mybatis_exception_token_redis.entity.Test;

import java.util.List;
import java.util.Map;

public interface TestService {

    List<Test> findByVin(String vin);

    List<Map<String,Object>> findByVinMap(String vin);
}
