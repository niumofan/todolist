package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.focus.AddFocusDTO;
import com.todolist_test2.demo.dto.focus.QueryFocusDTO;
import com.todolist_test2.demo.mbg.model.Focus;
import com.todolist_test2.demo.service.FocusService;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月20日 23:13
 */
@Api(tags = {"专注"}, description = "专注模式相关接口")
@RequestMapping("/focus")
@RestController
public class FocusController {

    @Autowired
    private FocusService focusService;

    @ApiOperation(value = "提交一次专注")
    @PostMapping("addFocus")
    public JsonResult<Focus> addFocus(@RequestBody @Validated AddFocusDTO focusDTO) {
        System.out.println(focusDTO);
        Focus focus = focusService.addFocus(focusDTO);
        return ResultTool.success(focus);
    }

    @RequiresRoles(value = {"ROLE_COMMON_USER"})
    @ApiOperation(value = "获取满足所有条件的专注记录", notes = "todoId, categoryId, userId有且只有一个能被赋值;")
    @PostMapping("queryFocus")
    public JsonResult<List<Focus>> queryFocus(@RequestBody @Validated QueryFocusDTO focusDTO) {
        System.out.println(focusDTO);
        List<Focus> focusList = null;
        if (focusDTO.getTodoId() != null) {
            focusList = focusService.queryFocusOfTodo(focusDTO);
        } else if (focusDTO.getCategoryId() != null) {
            focusList = focusService.queryFocusOfCategory(focusDTO);
        } else {
            focusList = focusService.queryFocusOfUser(focusDTO);
        }
        return ResultTool.success(focusList);
    }


}
