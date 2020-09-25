package com.rui.twodatabase.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SignConfigDao {
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "signName", column = "sign_name")

    })
    @Select("select id,sign_name from sign_config where sign_name =#{signName}")
    List<Map<String,Object>> findBSyignName(String signName);


}
