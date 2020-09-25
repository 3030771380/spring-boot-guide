package com.rui.es_mysql.dao.es;

import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface EsDwsFaultDMapper {

    List<Map<String,Object>> findByCity(@Param("endCounty") String endCounty);


    @Results({
            @Result(property = "dayStr", column = "day_str"),
            @Result(property = "endCity", column = "end_city"),
            @Result(property = "endCounty", column = "end_county")

    })
    @Select(" select day_str,end_city,end_county from dws_fault_d where end_county = #{endCounty}")
    List<LinkedHashMap<String,Object>> findByCitySql(String endCounty);
}
