package com.todolist_test2.demo.mbg.mapper;

import com.todolist_test2.demo.mbg.model.Subtask;
import com.todolist_test2.demo.mbg.model.SubtaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubtaskMapper {
    long countByExample(SubtaskExample example);

    int deleteByExample(SubtaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Subtask record);

    int insertSelective(Subtask record);

    List<Subtask> selectByExample(SubtaskExample example);

    Subtask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Subtask record, @Param("example") SubtaskExample example);

    int updateByExample(@Param("record") Subtask record, @Param("example") SubtaskExample example);

    int updateByPrimaryKeySelective(Subtask record);

    int updateByPrimaryKey(Subtask record);
}