package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.dto.focus.AddFocusDTO;
import com.todolist_test2.demo.dto.focus.QueryFocusDTO;
import com.todolist_test2.demo.mbg.model.Focus;
import com.todolist_test2.demo.vo.JsonResult;
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
@RequestMapping("/focus")
@RestController
public class FocusController {

    @PostMapping("addFocus")
    public JsonResult<Focus> addFocus(@RequestBody @Validated AddFocusDTO focusDTO) {
        System.out.println(focusDTO);
        return null;
    }

    @PostMapping("queryFocus")
    public JsonResult<List<Focus>> addFocus(@RequestBody @Validated QueryFocusDTO focusDTO) {
        System.out.println(focusDTO);
        return null;
    }
}
