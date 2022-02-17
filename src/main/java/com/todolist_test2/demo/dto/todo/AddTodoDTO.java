package com.todolist_test2.demo.dto.todo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 16:33
 */
@ApiModel(value = "添加待办事项的请求参数")
@Data
public class AddTodoDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull(message = "userId[user.id.notnull]")
    private Integer userId;

//    @ApiModelProperty(value = "待办事项所属的分类ID(不属于任何分类时为0)", example = "1", position = 1)
    @ApiModelProperty(hidden = true)
    private Integer categoryId = 0;

    @ApiModelProperty(value = "分类名(不属于任何分类时为'无分类')", example = "健身", position = 2)
    private String categoryName = "无分类";

    @ApiModelProperty(value = "待办内容", required = true, example = "跳绳20分钟", position = 3)
    @NotBlank(message = "content[todo.content.notblank]")
    @Size(max = 250, message = "content[todo.content.size]")
    private String content;

    @ApiModelProperty(value = "待办优先级(紧急程度:1[不紧急],2[比较紧急],3[非常紧急])", required = true, example = "2",
            position = 4)
    @Range(min=1, max=3, message = "priority[{todo.priority.range}]")
    private Byte priority = 1;

    @ApiModelProperty(value = "待办生效时间(YYYY-MM-DD hh:mm:ss)", required = true, example = "2022-05-30 09:12:34",
            position = 5)
    @Future(message = "startTime[{todo.startTime.future}]")
    @NotNull(message = "startTime[{todo.startTime.notnull}]")
    private Date startTime;

    @ApiModelProperty(value = "若为重复事项，startTime~endTime为事项生效的时间段;若为非重复事项，必须有startTime=endTime",
            required = true, example = "2022-07-31 08:59:59", position = 6)
    @Future(message = "endTime[{todo.endTime.future}]")
    @NotNull(message = "endTime[{todo.endTime.notnull}]")
    private Date endTime;

    @ApiModelProperty(value = "闹钟提醒时间", example = "['2022-05-30 08:55:00','2022-05-30 09:00:00']", position = 7)
    private String alarmTime;

    @ApiModelProperty(value = "子待办事项(json形式)", example = "\"[{'content':'跳绳20min'},{'content':'跑步20min'}]\"",
            position = 8)
    private String subtodos = "";

    @ApiModelProperty(value = "重复标识", example = "5", position = 9)
    private Byte repetition = 0;

}
