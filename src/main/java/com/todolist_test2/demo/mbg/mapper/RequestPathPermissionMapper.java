package com.todolist_test2.demo.mbg.mapper;

import com.todolist_test2.demo.mbg.model.RequestPathPermission;
import com.todolist_test2.demo.mbg.model.RequestPathPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestPathPermissionMapper {
    long countByExample(RequestPathPermissionExample example);

    int deleteByExample(RequestPathPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RequestPathPermission record);

    int insertSelective(RequestPathPermission record);

    List<RequestPathPermission> selectByExample(RequestPathPermissionExample example);

    RequestPathPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RequestPathPermission record, @Param("example") RequestPathPermissionExample example);

    int updateByExample(@Param("record") RequestPathPermission record, @Param("example") RequestPathPermissionExample example);

    int updateByPrimaryKeySelective(RequestPathPermission record);

    int updateByPrimaryKey(RequestPathPermission record);
}