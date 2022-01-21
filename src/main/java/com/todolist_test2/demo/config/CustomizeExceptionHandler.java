package com.todolist_test2.demo.config;

import com.todolist_test2.demo.enums.ResultCode;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author nmf
 * @date 2022年01月22日 0:16
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<Object> handle(Exception e) {
        if (e instanceof DuplicateKeyException) {
            return ResultTool.fail(ResultCode.DUPLICATE_ENTRY);
        }
        System.out.println(e.getClass());
        return ResultTool.fail(ResultCode.COMMON_FAIL);
    }
}
