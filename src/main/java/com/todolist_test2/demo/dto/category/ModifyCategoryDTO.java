package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author nmf
 * @date 2022年01月20日 16:18
 */
@ApiModel(value = "修改分类的请求参数")
@Data
public class ModifyCategoryDTO {

    @ApiModelProperty(value = "分类ID", required = true, example = "30")
    @NotNull(message = "id[{category.id.notnull}]")
    @Min(value = 1, message = "id[{category.id.min}]")
    private Integer id;

    @ApiModelProperty(value = "用户ID", required = true, example = "123456", position = 1)
    @NotNull(message = "userId[{user.id.notnull}]")
    @Min(value = 1, message = "userId[{user.id.min}]")
    private Integer userId;

    @ApiModelProperty(value = "新分类名(不能为空字符串)", required = true, example = "学习", position = 2)
    @NotBlank(message = "name[{category.name.notblank}]")
    @Size(max = 10, message = "name[{category.name.size}]")
    private String name;
}
