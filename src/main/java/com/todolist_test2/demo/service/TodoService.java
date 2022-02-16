package com.todolist_test2.demo.service;

import com.alibaba.fastjson.JSON;
import com.todolist_test2.demo.dao.TodoDao;
import com.todolist_test2.demo.dto.todo.AddTodoDTO;
import com.todolist_test2.demo.dto.todo.DeleteTodoDTO;
import com.todolist_test2.demo.dto.todo.ModifyTodoDTO;
import com.todolist_test2.demo.dto.todo.QueryTodoDTO;
import com.todolist_test2.demo.entity.Subtodo;
import com.todolist_test2.demo.enums.TodoState;
import com.todolist_test2.demo.mbg.mapper.TodoMapper;
import com.todolist_test2.demo.mbg.model.Todo;
import com.todolist_test2.demo.mbg.model.TodoExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author nmf
 * @date 2022年01月22日 1:53
 */
@Service
public class TodoService {

    private TodoMapper todoMapper;

    private TodoDao todoDao;

    @Autowired
    public void setTodoMapper(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Autowired
    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    /* 添加非重复待办 */
    public Todo addSingleTodo(AddTodoDTO todoDTO) {


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todoDTO.getStartTime());

        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setStartTime(calendar.getTime());
        todo.setState(TodoState.TODO.getCode().byteValue());
        todo.setSubtodos(initSubtodos(todoDTO.getSubtodos()));
        todo.setRepetition(System.currentTimeMillis());

        /* 若有闹钟 */
        List<Calendar> alarmTimeList = alarmStrToCalendar(todoDTO.getAlarmTime());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /* 有闹钟时，年月日设置为开始时间start_time，时分秒与传入的alarm_time参数相同 */
        updateAlarmTime(calendar, alarmTimeList, df, todo);

        calendar.add(Calendar.DATE, 1);

        todoMapper.insert(todo);
        return todo;
    }

    /* 添加重复待办 */
    public List<Todo> addRepeatedTodo(AddTodoDTO todoDTO) {
        List<Todo> todos = new ArrayList<>();

        /* 设置子任务状态为待办 */
        String subtodos = initSubtodos(todoDTO.getSubtodos());

        /* 判断星期几重复待办 */
        boolean[] flag = new boolean[7];
        Arrays.fill(flag, false);
        Byte repetition = todoDTO.getRepetition();
        for (int i = 0; i < 7; i++) {
            if (((repetition >>> i) & 0x1) != 0) {
                flag[i] = true;
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todoDTO.getStartTime());
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(todoDTO.getEndTime());
        endCalendar.add(Calendar.SECOND, 1);

        /* 将当前时间作为repetition标识 */
        Long rep = System.currentTimeMillis();

        /* 若有闹钟,转换为闹钟列表 */
        List<Calendar> alarmTimeList = alarmStrToCalendar(todoDTO.getAlarmTime());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (calendar.before(endCalendar)) {
            if (flag[calendar.get(Calendar.DAY_OF_WEEK) - 1]) {
                Todo todo = new Todo();
                BeanUtils.copyProperties(todoDTO, todo);
                todo.setStartTime(calendar.getTime());
                todo.setState(TodoState.TODO.getCode().byteValue());
                todo.setRepetition(rep);
                todo.setSubtodos(subtodos);

                /* 有闹钟时，年月日设置为开始时间start_time，时分秒与传入的alarm_time参数相同 */
                updateAlarmTime(calendar, alarmTimeList, df, todo);
                todos.add(todo);
            }
            calendar.add(Calendar.DATE, 1);
        }
        todoDao.insertTodos(todos);
        return todos;
    }

    private void updateAlarmTime(Calendar calendar, List<Calendar> alarmTimeList, DateFormat df, Todo todo) {
        if (alarmTimeList != null) {
            List<String> newTime = new ArrayList<>();
            for (Calendar alarmTime: alarmTimeList) {
                Calendar at = (Calendar) calendar.clone();
                at.set(Calendar.HOUR, alarmTime.get(Calendar.HOUR));
                at.set(Calendar.MINUTE, alarmTime.get(Calendar.MINUTE));
                at.set(Calendar.SECOND, alarmTime.get(Calendar.SECOND));
                newTime.add(df.format(at.getTime()));
            }
            todo.setAlarmTime(JSON.toJSONString(newTime));
        }
    }

    @Transactional
    public int deleteTodo(DeleteTodoDTO todoDTO) {
        int res;
        TodoExample example = new TodoExample();
        if (todoDTO.getRepetition()) {
            Long repetition = todoMapper.selectByPrimaryKey(todoDTO.getId()).getRepetition();
            example.createCriteria().
                    andUserIdEqualTo(todoDTO.getUserId()).
                    andRepetitionEqualTo(repetition).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
        } else {
            example.createCriteria().
                    andIdEqualTo(todoDTO.getId()).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
        }
        res = todoMapper.deleteByExample(example);
        return res;
    }

    @Transactional
    public Integer modifyTodo(ModifyTodoDTO todoDTO) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        todo.setUserId(null);
        todo.setRepetition(null);
        todo.setId(null);

        TodoExample example = new TodoExample();
        if (todoDTO.getRepetition()) {
            Long repetition = todoMapper.selectByPrimaryKey(todoDTO.getId()).getRepetition();
            System.out.println(repetition);
            example.createCriteria().
                    andStateEqualTo(TodoState.TODO.getCode().byteValue()).
                    andUserIdEqualTo(todoDTO.getUserId()).
                    andRepetitionEqualTo(repetition);
        } else {
            example.createCriteria().
                    andIdEqualTo(todoDTO.getId()).
                    andStateEqualTo(TodoState.TODO.getCode().byteValue());
        }
        todoMapper.updateByExampleSelective(todo, example);
        return 0;
    }

    public List<Todo> queryTodos(QueryTodoDTO todoDTO) {
        return todoDao.queryTodos(todoDTO);
    }

    /* 设置子任务状态为待办 */
    private String initSubtodos(String subtodos) {
        List<Subtodo> subtodoList;
        if (subtodos == null || subtodos.length() == 0) {
            subtodoList = new ArrayList<>(0);
        } else {
            subtodoList = JSON.parseArray(subtodos, Subtodo.class);
        }
        for (Subtodo subtodo: subtodoList) {
            subtodo.setState(TodoState.TODO);
        }
        return JSON.toJSONString(subtodoList);
    }

    private List<Calendar> alarmStrToCalendar(String alarmStr) {
        List<Calendar> alarmTimeList = null;
        List<Date> dates = JSON.parseArray(alarmStr, Date.class);
        if (dates.size() > 0) {
            alarmTimeList = new ArrayList<>();
            for (Date time: dates) {
                Calendar c = Calendar.getInstance();
                c.setTime(time);
                alarmTimeList.add(c);
            }
        }
        return alarmTimeList;
    }
}
