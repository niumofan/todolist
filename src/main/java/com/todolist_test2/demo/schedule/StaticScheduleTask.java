package com.todolist_test2.demo.schedule;

import com.todolist_test2.demo.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author nmf
 * @date 2022年01月27日 17:20
 */
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    private TodoDao todoDao;

    @Autowired
    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    /* 每天凌晨将前一天未完成的待办标记为“失败” */
    @Scheduled(cron = "0 5 0 * * ?")
    private void setTodoAsFailed() {
        Date yesterday = new Date();
        yesterday.setTime(yesterday.getTime() - 86400 * 1000);
        yesterday.setHours(0);
        yesterday.setMinutes(0);
        yesterday.setSeconds(0);
        todoDao.setTodoAsFailed(yesterday);
    }
}
