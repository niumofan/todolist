package com.todolist_test2.demo.controller;

import com.todolist_test2.demo.enums.KafkaTopic;
import com.todolist_test2.demo.utils.RedisService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {

    private RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }


    @KafkaListener(topics = KafkaTopic.REMOVE_CACHE)
    public void onMessage(ConsumerRecord<?, ?> record){
        System.out.println("简单消费，record："+record.topic()+"-"+record.partition()+"-"+record.value());
        redisService.del((String) record.value());
    }
}
