package com.todolist_test2.demo.entity;

import lombok.Data;

@Data
public class CategoryStatistic {

    private Integer categoryId;

    private String categoryName;

    private Integer complete;

    private Integer total;

}
