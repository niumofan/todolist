package com.todolist_test2.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Subtask implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "父任务ID")
    private Integer taskId;

    @ApiModelProperty(value = "内容")
    private String description;

    @ApiModelProperty(value = "优先级。1->不紧急；2->一般紧急；3->非常紧急")
    private Byte priority;

    @ApiModelProperty(value = "状态。1->待办: 到期前还没做; 2->完成: 到期前完成了; 3->失败: 到期时没有完成")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskId=").append(taskId);
        sb.append(", description=").append(description);
        sb.append(", priority=").append(priority);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}