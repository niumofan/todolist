package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.mbg.model.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月22日 2:44
 */
@Mapper
public interface TodoDao {

    int insertTodos(List<Todo> todos);

    int deleteTodos(List<Integer> todoIds);

}
