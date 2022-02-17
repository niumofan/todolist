package com.todolist_test2.demo.validator;

import com.todolist_test2.demo.dto.todo.ModifyTodoDTO;
import com.todolist_test2.demo.mbg.mapper.TodoMapper;
import com.todolist_test2.demo.mbg.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.Date;

public class EffectiveTodoValidator implements ConstraintValidator<EffectiveTodo, ModifyTodoDTO> {

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public void initialize(EffectiveTodo constraintAnnotation) {

    }

    @Override
    public boolean isValid(ModifyTodoDTO value, ConstraintValidatorContext context) {
        Todo todo = todoMapper.selectByPrimaryKey(value.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todo.getStartTime());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        return !calendar.before(today);
    }
}
