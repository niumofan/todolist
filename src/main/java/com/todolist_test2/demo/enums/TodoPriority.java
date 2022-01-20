package com.todolist_test2.demo.enums;

/**
 * @author nmf
 * @date 2022年01月20日 16:46
 */
public enum TodoPriority {

    NOT_IMPORTANT(1, "不紧急"),
    NORMAL(2, "一般"),
    IMPORTANT(3, "紧急")
    ;

    private Integer code;
    private String priority;

    TodoPriority(Integer code, String priority) {
        this.code = code;
        this.priority = priority;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
