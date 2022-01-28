package com.todolist_test2.demo.dto.todo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 17:24
 */
@ApiModel(value = "查询待办的请求参数", description = "所有查询条件为'and'关系")
@Data
public class QueryTodoDTO {

    @ApiModelProperty(value = "待办ID", example = "5")
    private Integer id;

    @ApiModelProperty(value = "分类ID", example = "10", position = 1)
    private Integer categoryId;

    @ApiModelProperty(value = "用户ID", required = true, example = "123456", position = 2)
    @NotNull(message = "userId[{user.id.notnull}]")
    private Integer userId;

    @ApiModelProperty(value = "紧急程度{1[不紧急], 2[一般], 3[非常紧急]}", example = "1", position = 3)
    @Range(message = "priority[{todo.priority.range}]")
    private Integer priority;

    @ApiModelProperty(value = "待办状态{1[待办], 2[完成], 3[失败]}", example = "2", position = 4)
    @Range(message = "state[{todo.state.range}]")
    private Integer state;

    @ApiModelProperty(value = "时间段开始时间", example = "2022-05-05 12:34:56", position = 5)
    private Date startTime;

    @ApiModelProperty(value = "时间段结束时间", example = "2022-06-07 21:32:43", position = 6)
    private Date endTime;
}
