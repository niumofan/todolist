package com.todolist_test2.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nmf
 * @date 2021年11月02日 20:31
 */
@Configuration
@MapperScan({"com.todolist_test2.demo.mbg.mapper", "com.todolist_test2.demo.dao"})
public class MybatisConfig {
}
