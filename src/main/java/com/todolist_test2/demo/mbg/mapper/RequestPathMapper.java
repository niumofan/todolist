package com.todolist_test2.demo.mbg.mapper;

import com.todolist_test2.demo.mbg.model.RequestPath;
import com.todolist_test2.demo.mbg.model.RequestPathExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestPathMapper {
    long countByExample(RequestPathExample example);

    int deleteByExample(RequestPathExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RequestPath record);

    int insertSelective(RequestPath record);

    List<RequestPath> selectByExample(RequestPathExample example);

    RequestPath selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RequestPath record, @Param("example") RequestPathExample example);

    int updateByExample(@Param("record") RequestPath record, @Param("example") RequestPathExample example);

    int updateByPrimaryKeySelective(RequestPath record);

    int updateByPrimaryKey(RequestPath record);
}