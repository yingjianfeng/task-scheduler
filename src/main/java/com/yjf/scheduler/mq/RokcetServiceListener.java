package com.yjf.scheduler.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Title: RokcetServiceListener
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/21 10:13
 */
@Component
@Slf4j
public class RokcetServiceListener {

    @Service
    @RocketMQMessageListener(consumerGroup = "consumer-group-1", topic = "rocket-topic-1")
    public class Consumer1 implements RocketMQListener<String> {

        @Override
        public void onMessage(String s) {
            log.info("consumer1 rocket收到消息：{}", s);
        }
    }

    @Service
        @RocketMQMessageListener(consumerGroup = "consumer-group-2", topic = "rocket-topic-2",
             messageModel = MessageModel.BROADCASTING)
    public class Consumer2 implements RocketMQListener<String> {
        @Override
        public void onMessage(String s) {
            log.info("consumer2 rocket收到消息：{}", s);
        }
    }

//    @Service
//    @RocketMQMessageListener(consumerGroup = "consumer-group-1", topic = "rocket-topic-1")
//    public class Consumer11 implements RocketMQListener<String> {
//
//        @Override
//        public void onMessage(String s) {
//            log.info("consumer11 rocket收到消息：{}", s);
//        }
//    }

//    // RocketMQ支持两种消费方式，集器消费和广播消费
//    @Service
//    @RocketMQMessageListener(consumerGroup = "consumer-group-2", topic = "rocket-topic-1",
//            selectorExpression = "tag2", messageModel = MessageModel.BROADCASTING)
//    public class Consumer2 implements RocketMQListener<String> {
//        @Override
//        public void onMessage(String s) {
//            log.info("consumer2 rocket收到消息：{}", s);
//        }
//    }
//
//    @Service
//    @RocketMQMessageListener(consumerGroup = "consumer-group-3", topic = "rocket-topic-1",
//            selectorExpression = "tag2", messageModel = MessageModel.BROADCASTING)
//    public class Consumer3 implements RocketMQListener<String> {
//        @Override
//        public void onMessage(String s) {
//            log.info("consumer3 rocket收到消息：{}", s);
//        }
//    }

}

