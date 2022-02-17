package com.todolist_test2.demo.dto.todo;

import com.todolist_test2.demo.validator.EffectiveTodo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 17:18
 */
@EffectiveTodo(message = "待办已过期，无法更改")
@ApiModel(value = "修改代办的请求参数")
@Data
public class ModifyTodoDTO {

    @ApiModelProperty(value = "待办ID", required = true, example = "10", position = 1)
    @NotNull(message = "id[{todo.id.notnull}]")
    private Integer id;

    @ApiModelProperty(value = "用户ID", required = true, example = "123456", position = 2)
    @NotNull(message = "userId[{user.id.notnull}]")
    private Integer userId;

//    @ApiModelProperty(value = "分类ID(与分类名要么同时存在，要么同时不存在)", example = "20", position = 3)
    @ApiModelProperty(hidden = true)
    private Integer categoryId;

    @ApiModelProperty(value = "分类名(与分类ID要么同时存在，要么同时不存在)", required = true, example = "10", position = 1)
    private String categoryName;

    @ApiModelProperty(value = "待办内容", example = "打豆豆", position = 5)
    @Size(min = 1, max = 30, message = "content[{todo.content.size}]")
    private String content;

    @ApiModelProperty(value = "紧急程度{1[不紧急], 2[一般], 3[非常紧急]}", example = "2", position = 6)
    @Range(min=1, max=3, message = "priority[{todo.priority.range}]")
    private Byte priority;

    @ApiModelProperty(value = "状态", example = "1", position = 7)
    @Range(min = 1, max = 3, message = "state[{todo.state.range}]")
    private Byte state;

    @ApiModelProperty(value = "闹钟时间", example = "['2022-05-30 08:55:00']", position = 8)
//    @Future(message = "alarmTime[{todo.alarmTime.future}]")
    private String alarmTime;

    @ApiModelProperty(value = "子待办事项列表", example = "[{'state':1,'content':'跳绳20min'},{'state':2,'content':'跑步20min'}]", position = 9)
    private String subtodos;

    @ApiModelProperty(value = "是否修改重复待办{true[是], false[否]}", required = true, example = "false", position = 10)
    @NotNull(message = "repetition[{todo.repetition.notnull}]")
    private Boolean repetition;
}
