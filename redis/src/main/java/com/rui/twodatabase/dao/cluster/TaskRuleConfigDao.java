package com.rui.twodatabase.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskRuleConfigDao {

    // 返回 Map 结果集
    @Select("select  task_code,task_name from task_rule_config where task_code = #{task_code}")
    List<Map<String,Object>> findByTaskName(String taskCode);
}
