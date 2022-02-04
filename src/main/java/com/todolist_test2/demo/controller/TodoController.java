package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.todo.AddTodoDTO;
import com.todolist_test2.demo.dto.todo.DeleteTodoDTO;
import com.todolist_test2.demo.dto.todo.ModifyTodoDTO;
import com.todolist_test2.demo.dto.todo.QueryTodoDTO;
import com.todolist_test2.demo.mbg.model.Todo;
import com.todolist_test2.demo.service.TodoService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nmf
 * @date 2021年11月10日 11:44
 */

@RequiresRoles(value = {"ROLE_COMMON_USER"})
@Api(tags = {"待办"}, description = "待办事项相关接口")
@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    @ApiOperation(value = "添加一个待办事项",
            notes = "可添加重复事项\n\n" +
                    "repetition为一个字节,第 i 位表示星期 i 是否重复待办事项。i=0为星期日，i=1为星期一, ..., i=6为星期六)\n" +
                    "如:\n\t5->0b00000101 (在 startTime ~ endTime 时间段内, 每周日和每周二重复待办)\n\t0 (只在 startTime 当天生效)")
    @PostMapping("addTodo")
    public JsonResult<List<Todo>> addTodo(@RequestBody @Validated AddTodoDTO todoDTO) {
        System.out.println(todoDTO);
        return ResultTool.success(todoService.addTodo(todoDTO));
    }

    @ApiOperation(value = "删除一个或多个待办事项")
    @PostMapping("deleteTodo")
    public JsonResult<Integer> deleteTodo(@RequestBody @Validated DeleteTodoDTO todoDTO) {
        System.out.println(todoDTO);
        int i = todoService.deleteTodo(todoDTO);
        return ResultTool.success(i);
    }

    @ApiOperation(value = "修改一个待办事项")
    @PostMapping("modifyTodo")
    public JsonResult<Integer> modifyTodo(@RequestBody @Validated ModifyTodoDTO todoDTO) {
        System.out.println(todoDTO);
        Integer i = todoService.modifyTodo(todoDTO);
        return ResultTool.success(i);
    }

    @ApiOperation(value = "查询符合所有条件的待办事项")
    @PostMapping("queryTodo")
    public JsonResult<List<Todo>> getTodos(@RequestBody @Validated QueryTodoDTO todoDTO) {
        System.out.println(todoDTO);
        return ResultTool.success(todoService.queryTodos(todoDTO));
    }
}
