package com.rui.es_mysql.service;

import java.util.List;
import java.util.Map;

public interface TaskRuleConfigService {
    List<Map<String,Object>> findByTaskName(String taskCode);
}
