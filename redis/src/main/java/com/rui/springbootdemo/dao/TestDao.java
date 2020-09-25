package com.rui.springbootdemo.dao;

import com.rui.springbootdemo.entity.Test;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {


// 返回 entity 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cellDuration", column = "cell_duration"),
            @Result(property = "time", column = "time"),
            @Result(property = "vin", column = "vin"),
    })
    @Select("SELECT id,vin FROM test where vin = #{vin}")
    List<Test> findByVin(String vin);

// 返回 Map 结果集

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cellDuration", column = "cell_duration"),
            @Result(property = "time", column = "time"),
            @Result(property = "vin", column = "vin"),
    })
    @Select("SELECT id,vin FROM test where vin = #{vin}")
    List<Map<String,Object>> findByVinMap(String vin);
}
