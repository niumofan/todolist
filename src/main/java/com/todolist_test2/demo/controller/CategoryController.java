package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.category.AddCategoryDTO;
import com.todolist_test2.demo.dto.category.DelCategoryDTO;
import com.todolist_test2.demo.dto.category.ModifyCategoryDTO;
import com.todolist_test2.demo.mbg.model.Category;
import com.todolist_test2.demo.vo.JsonResult;
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
@RequestMapping("/category")
@RestController
public class CategoryController {

    /* 添加一个分类 */
    @PostMapping("addCategory")
    public JsonResult<Category> addCatrgory(@RequestBody @Validated AddCategoryDTO addCategoryDTO) {
        System.out.println(addCategoryDTO);
        return null;
    }

    /* 删除某些分类 */
    @PostMapping("deleteCategory")
    public JsonResult<Boolean> deleteCategory(@RequestBody @Validated DelCategoryDTO delCategoryDTO) {
        System.out.println(delCategoryDTO);
        return null;
    }

    /* 修改分类信息 */
    @PostMapping("modifyCategory")
    public JsonResult<Category> modifyCategory(@RequestBody @Validated ModifyCategoryDTO updateCategoryDTO) {
        System.out.println(updateCategoryDTO);
        return null;
    }

    /* 获取某个用户的全部分类 */
    @PostMapping("queryCategories")
    public JsonResult<List<Category>> queryCategories(@RequestBody @Validated Integer userId) {
        System.out.println(userId);
        return null;
    }
}
