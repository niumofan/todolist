package com.todolist_test2.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;
import java.util.Properties;

/**
 * @author nmf
 * @date 2022年01月28日 1:36
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(Validator validator) {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator);
        return postProcessor;
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        // 设置messages资源信息
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // 多个用逗号分割
        messageSource.setBasenames("classpath:/ValidationMessages");
        // 设置字符集编码
        messageSource.setDefaultEncoding("UTF-8");
        validator.setValidationMessageSource(messageSource);
        // 设置验证相关参数
        Properties properties = new Properties();
        // 快速失败，只要有错马上返回
        properties.setProperty("hibernate.validator.fail_fast", "true");
        validator.setValidationProperties(properties);
        return validator;
    }
}
