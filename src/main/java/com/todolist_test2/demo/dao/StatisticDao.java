package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.dto.statistic.QueryCompletionOfCategoryDTO;
import com.todolist_test2.demo.entity.CategoryStatistic;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StatisticDao {

    @MapKey("categoryId")
    Map<Integer, Object> queryCompletionOfCategory(QueryCompletionOfCategoryDTO dto);
}
