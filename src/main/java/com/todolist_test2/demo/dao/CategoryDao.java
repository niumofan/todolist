package com.todolist_test2.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月22日 0:49
 */
@Mapper
public interface CategoryDao {
    int deleteCategoryByIds(List<Integer> categoryIds);
}
