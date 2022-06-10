package com.todolist_test2.demo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TodoVO {

    private Integer id;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "分类名")
    private String categoryName;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "优先级。1->不紧急；2->一般紧急；3->非常紧急")
    private Byte priority;

    @ApiModelProperty(value = "待办生效日期")
    private Date startTime;

    @ApiModelProperty(value = "提醒时间")
    private String alarmTime;

    @ApiModelProperty(value = "状态。1->待办: 到期前还没做; 2->完成: 到期前完成了; 3->失败: 到期时没有完成")
    private Byte state;

    @ApiModelProperty(value = "子待办事项，以json形式存储([{state:1, content:'todo1'},{...}])")
    private String subtodos;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getSubtodos() {
        return subtodos;
    }

    public void setSubtodos(String subtodos) {
        this.subtodos = subtodos;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", content=").append(content);
        sb.append(", priority=").append(priority);
        sb.append(", startTime=").append(startTime);
        sb.append(", alarmTime=").append(alarmTime);
        sb.append(", state=").append(state);
        sb.append(", subtodos=").append(subtodos);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
