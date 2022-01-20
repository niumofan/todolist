package com.todolist_test2.demo.enums;

import lombok.Data;

/**
 * @author nmf
 * @date 2022年01月20日 16:37
 */
public enum TodoState {

    TODO(1, "待办"),
    FINISHED(2, "完成"),
    FAIL(3, "失败");

    private Integer code;

    private String state;

    TodoState(Integer code, String state) {
        this.code = code;
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
