package com.todolist_test2.demo.entity;

import com.todolist_test2.demo.enums.TodoState;
import lombok.Data;

/**
 * @author nmf
 * @date 2022年01月22日 3:02
 */
@Data
public class Subtodo {

    private String description;
    private Byte state;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
