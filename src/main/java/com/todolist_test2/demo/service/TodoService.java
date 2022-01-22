package com.todolist_test2.demo.service;

import com.alibaba.fastjson.JSON;
import com.todolist_test2.demo.dao.TodoDao;
import com.todolist_test2.demo.dto.category.AddCategoryDTO;
import com.todolist_test2.demo.dto.category.DelCategoryDTO;
import com.todolist_test2.demo.dto.category.ModifyCategoryDTO;
import com.todolist_test2.demo.dto.category.QueryCategoryDTO;
import com.todolist_test2.demo.dto.todo.AddTodoDTO;
import com.todolist_test2.demo.dto.todo.DeleteTodoDTO;
import com.todolist_test2.demo.dto.todo.ModifyTodoDTO;
import com.todolist_test2.demo.entity.Subtodo;
import com.todolist_test2.demo.enums.TodoState;
import com.todolist_test2.demo.mbg.mapper.TodoMapper;
import com.todolist_test2.demo.mbg.model.Category;
import com.todolist_test2.demo.mbg.model.CategoryExample;
import com.todolist_test2.demo.mbg.model.Todo;
import com.todolist_test2.demo.mbg.model.TodoExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author nmf
 * @date 2022年01月22日 1:53
 */
@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private TodoDao todoDao;

    /* 添加待办 */
    public List<Todo> addTodo(AddTodoDTO todoDTO) {
        List<Todo> todos = new ArrayList<>();

        /* 设置子任务状态为待办 */
        List<Subtodo> subtodoList;
        String subtodos = todoDTO.getSubtodos();
        if (subtodos == null || subtodos.length() == 0) {
            subtodoList = new ArrayList<>(0);
        } else {
            subtodoList = JSON.parseArray(subtodos, Subtodo.class);
        }
        for (Subtodo subtodo: subtodoList) {
            subtodo.setState(TodoState.TODO);
        }
        subtodos = JSON.toJSONString(subtodoList);

        /* 判断星期几重复待办 */
        boolean[] flag = new boolean[7];
        Arrays.fill(flag, false);
        Byte repeat = todoDTO.getRepeat();
        for (int i = 0; i < 7; i++) {
            if (((repeat >>> i) & 0x1) != 0) {
                flag[i] = true;
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todoDTO.getStartTime());
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(todoDTO.getEndTime());

        /* 将当前时间作为repeat标识 */
        Integer rep = new Long(System.currentTimeMillis()).hashCode();

        /* 若有闹钟 */
        Calendar alarmTime;
        if (todoDTO.getAlarmTime() != null) {
            alarmTime = Calendar.getInstance();
            alarmTime.setTime(todoDTO.getAlarmTime());
        } else {
            alarmTime = null;
        }


        while (calendar.before(endCalendar)) {
            if (flag[calendar.get(Calendar.DAY_OF_WEEK) - 1]) {
                Todo todo = new Todo();
                BeanUtils.copyProperties(todoDTO, todo);
                todo.setStartTime(calendar.getTime());
                todo.setState(TodoState.TODO);
                todo.setRepeat(rep);
                todo.setSubtodos(subtodos);
                /* 有闹钟时，年月日设置为开始时间start_time，时分秒与传入的alarm_time参数相同 */
                if (alarmTime != null) {
                    Calendar at = (Calendar) calendar.clone();
                    at.set(Calendar.HOUR, alarmTime.get(Calendar.HOUR));
                    at.set(Calendar.MINUTE, alarmTime.get(Calendar.MINUTE));
                    at.set(Calendar.SECOND, alarmTime.get(Calendar.SECOND));
                    todo.setAlarmTime(at.getTime());
                }
                todos.add(todo);
            }
            calendar.add(Calendar.DATE, 1);
        }
        todoDao.insertTodos(todos);
        return todos;
    }

    @Transactional
    public int deleteTodo(DeleteTodoDTO todoDTO) {
//        return categoryDao.deleteCategoryByIds(categoryDTO.getCategoryIds());
        int res;
        if (todoDTO.getRepeat() != 0) {
            TodoExample example = new TodoExample();
            example.createCriteria().
                    andUserIdEqualTo(todoDTO.getUserId()).
                    andRepeatEqualTo(todoDTO.getRepeat()).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
            res = todoMapper.deleteByExample(example);
        } else {
            TodoExample example = new TodoExample();
            example.createCriteria().
                    andIdEqualTo(todoDTO.getId()).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
            res = todoMapper.deleteByExample(example);
        }
        return res;
    }

    @Transactional
    public Integer modifyTodo(ModifyTodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setUserId(null);
        todo.setRepeat(null);
        todo.setId(null);

        if (todoDTO.getRepeat() != 0) {
            TodoExample example = new TodoExample();
            example.createCriteria().
                    andStateEqualTo(TodoState.TODO.getCode().byteValue()).
                    andUserIdEqualTo(todoDTO.getUserId()).
                    andRepeatEqualTo(todoDTO.getRepeat());
            todoMapper.updateByExampleSelective(todo, example);
        } else {
            TodoExample example = new TodoExample();
            example.createCriteria().
                    andIdEqualTo(todoDTO.getId()).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
            todoMapper.updateByExampleSelective(todo,example);
        }
        return 0;
    }

//    public List<Category> queryCategories(QueryCategoryDTO categoryDTO) {
//        CategoryExample example = new CategoryExample();
//        example.createCriteria().andUserIdEqualTo(categoryDTO.getUserId());
//        return categoryMapper.selectByExample(example);
//    }
}
