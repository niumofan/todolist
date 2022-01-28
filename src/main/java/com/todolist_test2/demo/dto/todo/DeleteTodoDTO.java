package com.todolist_test2.demo.dto.todo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月20日 17:13
 */
@ApiModel(value = "删除待办的请求参数")
@Data
public class DeleteTodoDTO {

    @ApiModelProperty(value = "待办ID", required = true, example = "1800", position = 1)
    @NotNull(message = "id[{todo.id.notnull}]")
    private Integer id;

    @ApiModelProperty(value = "用户ID", example = "123456", position = 2)
    @NotNull(message = "userId[{user.id.notnull}]")
    private Integer userId;

    @ApiModelProperty(value = "是否删除重复待办", example = "true", position = 6)
    @NotNull(message = "repetition[{todo.repetition.notnull}]")
    private Boolean repetition;

}
