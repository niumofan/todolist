package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.todo.AddTodoDTO;
import com.todolist_test2.demo.dto.todo.DeleteTodoDTO;
import com.todolist_test2.demo.dto.todo.ModifyTodoDTO;
import com.todolist_test2.demo.dto.todo.QueryTodoDTO;
import com.todolist_test2.demo.mbg.model.Todo;
import com.todolist_test2.demo.service.TodoService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月10日 11:44
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("addTodo")
    public JsonResult<List<Todo>> addTodo(@RequestBody @Validated AddTodoDTO todoDTO) {
        System.out.println(todoDTO);
        return ResultTool.success(todoService.addTodo(todoDTO));
    }

    @PostMapping("deleteTodo")
    public JsonResult<Integer> deleteTodo(@RequestBody @Validated DeleteTodoDTO todoDTO) {
        System.out.println(todoDTO);
        int i = todoService.deleteTodo(todoDTO);
        return ResultTool.success(i);
    }

    @PostMapping("modifyTodo")
    public JsonResult<Integer> modifyTodo(@RequestBody @Validated ModifyTodoDTO todoDTO) {
        System.out.println(todoDTO);
        Integer i = todoService.modifyTodo(todoDTO);
        return ResultTool.success(i);
    }

    @PostMapping("queryTodo")
    public JsonResult<List<Todo>> getTodos(@RequestBody @Validated QueryTodoDTO todoDTO) {
        System.out.println(todoDTO);
        return ResultTool.success(todoService.queryTodos(todoDTO));
    }
}
