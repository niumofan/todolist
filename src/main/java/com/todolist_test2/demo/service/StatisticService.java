package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.StatisticDao;
import com.todolist_test2.demo.dto.statistic.QueryCompletionOfCategoryDTO;
import com.todolist_test2.demo.entity.CategoryStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticService {

    private StatisticDao statisticDao;

    @Autowired
    public void setStatisticDao(StatisticDao statisticDao) {
        this.statisticDao = statisticDao;
    }

    public Map<Integer, Object> queryCompletionOfCategory(QueryCompletionOfCategoryDTO dto) {
        return statisticDao.queryCompletionOfCategory(dto);
    }
}
