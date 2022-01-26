package com.todolist_test2.demo.dao;

import com.todolist_test2.demo.dto.focus.QueryFocusDTO;
import com.todolist_test2.demo.mbg.model.Focus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月26日 12:30
 */
@Mapper
public interface FocusDao {

    List<Focus> queryFocusOfTodo(QueryFocusDTO focusDTO);

    List<Focus> queryFocusOfCategory(QueryFocusDTO focusDTO);

    List<Focus> queryFocusOfUser(QueryFocusDTO focusDTO);

}
