package com.todolist_test2.demo.dto.statistic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@ApiModel(value = "查询某用户某段时间内各类别Todo完成情况")
@Data
public class QueryCompletionOfCategoryDTO {

    @ApiModelProperty(value = "用户ID", example = "123456")
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "开始时间", example = "2022-01-01 00:00:00", position = 1)
    @Past(message = "endTime[{statistic.startTime.past}]")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", example = "2022-12-31 23:59:59", position = 2)
    @Past(message = "endTime[{statistic.endTime.past}]")
    private Date endTime;
}
