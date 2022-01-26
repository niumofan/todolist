package com.todolist_test2.demo.dto.focus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 23:18
 */
@ApiModel(value = "查询专注记录的请求参数")
@Data
public class QueryFocusDTO {

    @ApiModelProperty(value = "待办ID", example = "30", position = 1)
    private Integer todoId;

    @ApiModelProperty(value = "分类ID", example = "10", position = 2)
    private Integer categoryId;

    @ApiModelProperty(value = "用户ID", example = "123456", position = 3)
    private Integer userId;

    @ApiModelProperty(value = "查询时间段开始时间", example = "2022-01-01 00:00:00", position = 4)
    private Date startTime;

    @ApiModelProperty(value = "查询时间段结束时间", example = "2022-12-31 23:59:59", position = 5)
    private Date endTime;

    @ApiModelProperty(value = "查询专注时长 大于等于或小于等于 duration 的专注记录（单位:秒）", example = "1800", position = 6)
    private Short duration;

    @ApiModelProperty(value = "true[大于等于], false[小于等于]", example = "true", position = 7)
    private Boolean greater;
}
