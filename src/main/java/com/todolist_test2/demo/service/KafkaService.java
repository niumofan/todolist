package com.todolist_test2.demo.service;

import com.todolist_test2.demo.enums.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class KafkaService {

    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRemoveCache(String message) {
        try {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(KafkaTopic.REMOVE_CACHE, message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    System.err.println("removeCache - 生产者 发送消息失败：" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    System.out.println("removeCache - 生产者 发送消息成功：" + stringObjectSendResult.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return true;
    }

}
