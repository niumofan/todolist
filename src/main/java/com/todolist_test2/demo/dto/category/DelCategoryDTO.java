package com.todolist_test2.demo.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 16:12
 */
@ApiModel(value = "删除分类的请求参数")
@Data
public class DelCategoryDTO {

//    @NotNull
//    private Integer userId;


    @ApiModelProperty(value = "分类ID列表(不能为空表)", required = true, example = "[1,2,3]")
    @Size(min = 1)
    private List<Integer> categoryIds;
}
