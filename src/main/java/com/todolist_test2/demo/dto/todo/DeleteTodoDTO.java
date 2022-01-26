package com.todolist_test2.demo.dto.todo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 17:13
 */
@Data
public class DeleteTodoDTO {

    //    @Size(min = 1)
    @ApiModelProperty(value = "待办ID", example = "1800", position = 1)
    private Integer id;

    @ApiModelProperty(value = "用户ID", example = "123456", position = 2)
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "是否删除重复待办", example = "", position = 6)
    @NotNull
    private Long repeat;

}
