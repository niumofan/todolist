package com.todolist_test2.demo.dto.todo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 17:18
 */
@ApiModel(value = "修改代办的请求参数")
@Data
public class ModifyTodoDTO {

    @ApiModelProperty(value = "待办ID", required = true, example = "10", position = 1)
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "用户ID", required = true, example = "123456", position = 2)
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "分类ID", example = "20", position = 3)
    private Integer categoryId;

//    @ApiModelProperty(value = "待办名", required = true, example = "10", position = 1)
//    private String categoryName;

    @ApiModelProperty(value = "待办内容", example = "打豆豆", position = 5)
    private String content;

    @ApiModelProperty(value = "紧急程度", example = "2", position = 6)
    @Range(min=1, max=3)
    private Integer priority;

//    @Future
//    private Date startTime;

    @ApiModelProperty(value = "闹钟时间", example = "2022-05-30 08:55:00", position = 7)
    @Future
    private Date alarmTime;

    @ApiModelProperty(value = "子待办事项列表", example = "[{'content':'跳绳20min'},{'content':'跑步20min'}]", position = 8)
    private String subtodos;

    @ApiModelProperty(value = "是否修改重复待办", required = true, example = "false", position = 9)
    @NotNull
    private Boolean repetition;
}
