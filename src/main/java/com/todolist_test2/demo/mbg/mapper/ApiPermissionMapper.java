package com.todolist_test2.demo.mbg.mapper;

import com.todolist_test2.demo.mbg.model.ApiPermission;
import com.todolist_test2.demo.mbg.model.ApiPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiPermissionMapper {
    long countByExample(ApiPermissionExample example);

    int deleteByExample(ApiPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApiPermission record);

    int insertSelective(ApiPermission record);

    List<ApiPermission> selectByExample(ApiPermissionExample example);

    ApiPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApiPermission record, @Param("example") ApiPermissionExample example);

    int updateByExample(@Param("record") ApiPermission record, @Param("example") ApiPermissionExample example);

    int updateByPrimaryKeySelective(ApiPermission record);

    int updateByPrimaryKey(ApiPermission record);
}