package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dto.category.AddCategoryDTO;
import com.todolist_test2.demo.mbg.mapper.CategoryMapper;
import com.todolist_test2.demo.mbg.model.Category;
import org.springframework.stereotype.Service;

/**
 * @author nmf
 * @date 2022年01月21日 23:25
 */
@Service
public class CategoryService {

    private CategoryMapper categoryMapper;

    public Category addCategory(AddCategoryDTO categoryDTO) {
        Category category = new Category(null, categoryDTO.getUserId(), categoryDTO.getName());
        return null;
    }
}
