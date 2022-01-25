package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.category.AddCategoryDTO;
import com.todolist_test2.demo.dto.category.DelCategoryDTO;
import com.todolist_test2.demo.dto.category.ModifyCategoryDTO;
import com.todolist_test2.demo.dto.category.QueryCategoryDTO;
import com.todolist_test2.demo.mbg.model.Category;
import com.todolist_test2.demo.service.CategoryService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 15:53
 */
@Api("分类相关接口")
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /* 添加一个分类 */
    @ApiOperation(value = "添加一个分类")
    @PostMapping("addCategory")
    public JsonResult<Category> addCatrgory(@RequestBody @Validated AddCategoryDTO addCategoryDTO) {
        System.out.println(addCategoryDTO);
        return ResultTool.success(categoryService.addCategory(addCategoryDTO));
    }

    /* 删除某些分类 */
    @ApiOperation(value = "删除一个或多个分类")
    @PostMapping("deleteCategory")
    public JsonResult<Integer> deleteCategory(@RequestBody @Validated DelCategoryDTO delCategoryDTO) {
        System.out.println(delCategoryDTO);
        int n = categoryService.deleteCategory(delCategoryDTO);
        return ResultTool.success(n);
    }

    /* 修改分类信息 */
    @ApiOperation(value = "修改一个分类(目前只修改分类名)")
    @PostMapping("modifyCategory")
    public JsonResult<Category> modifyCategory(@RequestBody @Validated ModifyCategoryDTO updateCategoryDTO) {
        System.out.println(updateCategoryDTO);
        Category category = categoryService.modifyCategory(updateCategoryDTO);
        return ResultTool.success(category);
    }

    /* 获取某个用户的全部分类 */
    @ApiOperation(value = "查询某个用户创建的所有分类")
    @PostMapping("queryCategory")
    public JsonResult<List<Category>> queryCategories(@RequestBody @Validated QueryCategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        return ResultTool.success(categoryService.queryCategories(categoryDTO));
    }
}
