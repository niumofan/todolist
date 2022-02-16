package com.todolist_test2.demo.config;

import com.todolist_test2.demo.enums.ResultCode;
import com.todolist_test2.demo.utils.ResultTool;
import com.todolist_test2.demo.vo.JsonResult;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author nmf
 * @date 2022年01月22日 0:16
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<Object> handle(Exception e) {

        /* 数据库存在重复条目 */
        if (e instanceof DuplicateKeyException) {
            return ResultTool.fail(ResultCode.DUPLICATE_ENTRY);
        }
        /* 传入参数校验异常 */
        else if (e instanceof MethodArgumentNotValidException) {
            String msg = Objects.requireNonNull(((MethodArgumentNotValidException) e).getBindingResult().getFieldError()).getDefaultMessage();
            return ResultTool.fail(ResultCode.PARAM_NOT_VALID, msg);
        }
        /* 认证失败 */
        else if (e instanceof AuthenticationException) {
            return ResultTool.fail(ResultCode.AUTHENTICATION_ERROR);
        }
        return ResultTool.fail(ResultCode.COMMON_FAIL, e.getMessage());
    }
}
