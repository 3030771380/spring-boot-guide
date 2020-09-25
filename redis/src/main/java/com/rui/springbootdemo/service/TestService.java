package com.rui.springbootdemo.service;

import com.rui.springbootdemo.entity.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestService {

    List<Test> findByVin(String vin);

    List<Map<String,Object>> findByVinMap(String vin);
}
