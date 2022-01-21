package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.CategoryDao;
import com.todolist_test2.demo.dto.category.AddCategoryDTO;
import com.todolist_test2.demo.dto.category.DelCategoryDTO;
import com.todolist_test2.demo.dto.category.ModifyCategoryDTO;
import com.todolist_test2.demo.dto.category.QueryCategoryDTO;
import com.todolist_test2.demo.mbg.mapper.CategoryMapper;
import com.todolist_test2.demo.mbg.model.Category;
import com.todolist_test2.demo.mbg.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月21日 23:25
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryDao categoryDao;

    public Category addCategory(AddCategoryDTO categoryDTO) {
        Category category = new Category(null, categoryDTO.getUserId(), categoryDTO.getName());
        categoryMapper.insert(category);
        return category;
    }

    @Transactional
    public int deleteCategory(DelCategoryDTO categoryDTO) {
        return categoryDao.deleteCategoryByIds(categoryDTO.getCategoryIds());
    }

    public Category modifyCategory(ModifyCategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getId(), categoryDTO.getUserId(), categoryDTO.getName());
        categoryMapper.updateByPrimaryKey(category);
        return category;
    }

    public List<Category> queryCategories(QueryCategoryDTO categoryDTO) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andUserIdEqualTo(categoryDTO.getUserId());
        return categoryMapper.selectByExample(example);
    }
}
