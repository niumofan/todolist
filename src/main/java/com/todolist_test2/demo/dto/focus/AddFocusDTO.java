package com.todolist_test2.demo.dto.focus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月20日 23:16
 */
@ApiModel(description = "提交专注记录的请求参数")
@Data
public class AddFocusDTO {

    @ApiModelProperty(value = "用户ID", required = true, example = "123456")
    @NotNull
    private Integer userId;

    @ApiModelProperty(value = "待办ID", required = true, example = "30", position = 2)
    @NotNull
    private Integer todoId;

    @ApiModelProperty(value = "专注开始时间", required = true, example = "2022-01-26 09:00:00", position = 3)
    @Past
    private Date startTime;

    @ApiModelProperty(value = "专注结束时间", required = true, example = "2022-01-26 09:30:41", position = 4)
    @Past
    private Date endTime;
}
