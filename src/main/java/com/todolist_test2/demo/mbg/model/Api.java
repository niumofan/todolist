package com.todolist_test2.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Api implements Serializable {
    @ApiModelProperty(value = "请求路径ID")
    private Integer id;

    @ApiModelProperty(value = "请求路径")
    private String url;

    @ApiModelProperty(value = "功能描述")
    private String content;

    private static final long serialVersionUID = 1L;

    public Api(Integer id, String url, String content) {
        this.id = id;
        this.url = url;
        this.content = content;
    }

    public Api() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}