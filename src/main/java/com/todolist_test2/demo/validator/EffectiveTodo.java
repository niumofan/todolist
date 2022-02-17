package com.todolist_test2.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
@Constraint(validatedBy = EffectiveTodoValidator.class)
public @interface EffectiveTodo {

    String message() default "待办已过期，无法更改";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
