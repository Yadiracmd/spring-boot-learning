package com.ztf.boot.task.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CreateMapper {



    List<String> getTableList();


    List<Map<String, Object>> getDates(@Param("tableName") String tableName);
}
