package com.todolist_test2.demo.mbg.mapper;

import com.todolist_test2.demo.mbg.model.Focus;
import com.todolist_test2.demo.mbg.model.FocusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FocusMapper {
    long countByExample(FocusExample example);

    int deleteByExample(FocusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Focus record);

    int insertSelective(Focus record);

    List<Focus> selectByExample(FocusExample example);

    Focus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Focus record, @Param("example") FocusExample example);

    int updateByExample(@Param("record") Focus record, @Param("example") FocusExample example);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}