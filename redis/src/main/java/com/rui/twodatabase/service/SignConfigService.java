package com.rui.twodatabase.service;

import java.util.List;
import java.util.Map;

public interface SignConfigService {
    List<Map<String,Object>> findBySignName(String signName);
}
