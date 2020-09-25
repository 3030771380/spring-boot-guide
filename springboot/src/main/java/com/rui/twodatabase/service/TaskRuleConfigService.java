package com.rui.twodatabase.service;

import java.util.List;
import java.util.Map;

public interface TaskRuleConfigService {
    List<Map<String,Object>> findByTaskName(String taskCode);
}
