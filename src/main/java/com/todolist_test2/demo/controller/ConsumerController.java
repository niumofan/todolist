package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.config.RedisConfig;
import com.todolist_test2.demo.enums.KafkaTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = KafkaTopic.REMOVE_CACHE)
    public void onMessage(ConsumerRecord<?, ?> record){
        System.out.println("简单消费，record："+record.topic()+"-"+record.partition()+"-"+record.value());
        redisTemplate.delete((String) record.value());
    }
}
