package com.todolist_test2.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "分类名")
    private String categoryName;

    @ApiModelProperty(value = "内容")
    private String description;

    @ApiModelProperty(value = "优先级。1->不紧急；2->一般紧急；3->非常紧急")
    private Byte priority;

    @ApiModelProperty(value = "待办生效日期")
    private Date startTime;

    @ApiModelProperty(value = "提醒时间")
    private Date alarmTime;

    @ApiModelProperty(value = "状态。1->待办: 到期前还没做; 2->完成: 到期前完成了; 3->失败: 到期时没有完成")
    private Byte state;

    @ApiModelProperty(value = "子待办事项，以json形式存储([{state:1, content:'todo1'},{...}])")
    private String subtodos;

    @ApiModelProperty(value = "重复标识")
    private Integer repeat;

    private static final long serialVersionUID = 1L;

    public Todo(Integer id, Integer userId, Integer categoryId, String categoryName, String description, Byte priority, Date startTime, Date alarmTime, Byte state, String subtodos, Integer repeat) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.priority = priority;
        this.startTime = startTime;
        this.alarmTime = alarmTime;
        this.state = state;
        this.subtodos = subtodos;
        this.repeat = repeat;
    }

    public Todo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
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

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", description=").append(description);
        sb.append(", priority=").append(priority);
        sb.append(", startTime=").append(startTime);
        sb.append(", alarmTime=").append(alarmTime);
        sb.append(", state=").append(state);
        sb.append(", subtodos=").append(subtodos);
        sb.append(", repeat=").append(repeat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}