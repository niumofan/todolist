package com.todolist_test2.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Role implements Serializable {
    @ApiModelProperty(value = "角色ID")
    private Integer id;

    @ApiModelProperty(value = "角色名(英文)")
    private String code;

    @ApiModelProperty(value = "角色名(中文)")
    private String name;

    private static final long serialVersionUID = 1L;

    public Role(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}