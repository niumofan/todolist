package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.dto.category.QueryCategoryDTO;
import com.todolist_test2.demo.mbg.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月22日 0:49
 */
@Mapper
public interface CategoryDao {

    List<Category> query(QueryCategoryDTO dto);

    int deleteCategoryByIds(List<Integer> categoryIds);
}
