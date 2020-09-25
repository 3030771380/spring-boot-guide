package com.rui.twodatabase.service.impl;

import com.rui.twodatabase.dao.cluster.TaskRuleConfigDao;
import com.rui.twodatabase.service.TaskRuleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskRuleConfigServiceImpl implements TaskRuleConfigService {

    @Autowired
    TaskRuleConfigDao taskRuleConfigDao;
    /**
     * 查询任务
     * @param taskCode
     * @return
     */
    @Override
    public List<Map<String, Object>> findByTaskName(String taskCode) {
        return taskRuleConfigDao.findByTaskName(taskCode);
    }
}
