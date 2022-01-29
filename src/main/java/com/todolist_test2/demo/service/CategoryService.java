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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月21日 23:25
 */
@CacheConfig(cacheManager = "cacheManager", cacheNames = "category")
@Service
public class CategoryService {

    private CategoryMapper categoryMapper;

    private CategoryDao categoryDao;

    private KafkaService kafkaService;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Autowired
    public void setKafkaService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public Category addCategory(AddCategoryDTO categoryDTO) {
        Category category = new Category(null, categoryDTO.getUserId(), categoryDTO.getName());
        int i = categoryMapper.insert(category);
        if (i > 0) {
            kafkaService.sendRemoveCache("category::" + categoryDTO.getUserId());
        }
        return category;
    }

    @Transactional
    public int deleteCategory(DelCategoryDTO categoryDTO) {
        int i = categoryDao.deleteCategoryByIds(categoryDTO.getCategoryIds());
        if (i > 0) {
            kafkaService.sendRemoveCache("category::" + categoryDTO.getUserId());
        }
        return i;
    }

    public Category modifyCategory(ModifyCategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        int i = categoryMapper.updateByPrimaryKeySelective(category);
        if (i > 0) {
            kafkaService.sendRemoveCache("category::" + categoryDTO.getUserId());
        }
        return category;
    }

    @Cacheable(key = "#categoryDTO.userId")
    public List<Category> queryCategories(QueryCategoryDTO categoryDTO) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andUserIdEqualTo(categoryDTO.getUserId());
        return categoryMapper.selectByExample(example);
    }
}
