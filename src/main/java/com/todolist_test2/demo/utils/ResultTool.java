package com.todolist_test2.demo.utils;

import com.todolist_test2.demo.enums.ResultCode;
import com.todolist_test2.demo.vo.JsonResult;

/**
 * @author nmf
 * @date 2021年11月02日 10:34
 */
public class ResultTool {

    public static JsonResult<Object> success() {
        return new JsonResult<>(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(true, data);
    }

    public static JsonResult<Object> fail() {
        return new JsonResult<>(false);
    }

    public static JsonResult<ResultCode> fail(ResultCode resultEnum) {
        return new JsonResult<>(false, resultEnum);
    }
}
