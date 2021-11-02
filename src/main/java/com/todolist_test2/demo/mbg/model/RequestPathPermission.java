package com.todolist_test2.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class RequestPathPermission implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "请求路径ID")
    private Integer requestPathId;

    @ApiModelProperty(value = "权限ID")
    private Integer permissionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestPathId() {
        return requestPathId;
    }

    public void setRequestPathId(Integer requestPathId) {
        this.requestPathId = requestPathId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", requestPathId=").append(requestPathId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}