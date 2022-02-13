package com.todolist_test2.demo.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ImageDTO {

    @NotNull
    private Integer userId;

    @NotBlank
    private String base64Image;

}
