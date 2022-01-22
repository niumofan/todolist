package com.todolist_test2.demo.entity;

import com.todolist_test2.demo.enums.TodoState;
import lombok.Data;

/**
 * @author nmf
 * @date 2022年01月22日 3:02
 */
@Data
public class Subtodo {

    private String content;
    private Byte state;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public void setState(TodoState state) {
        this.state = state.getCode().byteValue();
    }

}
