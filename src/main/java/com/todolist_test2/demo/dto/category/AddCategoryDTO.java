package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nmf
 * @date 2022年01月20日 15:57
 */
@ApiModel(description = "添加分类的请求参数")
@Data
public class AddCategoryDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "分类名(不能为空字符串)", required = true, example = "健身", position = 1)
    @NotBlank
    private String name;
}
