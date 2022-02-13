package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.statistic.QueryCompletionOfCategoryDTO;
import com.todolist_test2.demo.entity.CategoryStatistic;
import com.todolist_test2.demo.service.StatisticService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Api(tags = {"统计"}, description = "用户使用统计相关接口")
@RequestMapping("/statistic")
@RestController
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping("completionOfCategory")
    public JsonResult<Map<Integer, Object>> queryCompletionOfCategory(
            @RequestBody QueryCompletionOfCategoryDTO dto) {
        Map<Integer, Object> result = statisticService.queryCompletionOfCategory(dto);
        return ResultTool.success(result);
    }

}
