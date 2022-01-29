package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月22日 1:42
 */
@ApiModel(value = "查询分类的请求参数")
@Data
public class QueryCategoryDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull(message = "userId[{user.id.notnull}]")
    @Min(value = 1, message = "userId[{user.id.min}]")
    private Integer userId;
}
