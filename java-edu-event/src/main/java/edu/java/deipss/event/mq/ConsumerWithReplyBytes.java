package edu.java.deipss.event.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Service;

import static edu.java.deipss.service.test.domain.constant.TopicConstant.*;

/// @Service
@Slf4j
@RocketMQMessageListener(topic = EDU_TOPIC_1,
        consumerGroup = EDU_TOPIC_GROUP+"1",
        selectorExpression = EDU_TAG_1)
public class ConsumerWithReplyBytes implements RocketMQReplyListener<MessageExt, byte[]> {

    @Override
    public byte[] onMessage(MessageExt message) {
        log.info("------- ConsumerWithReplyBytes received={}", message);
        return "reply message content".getBytes();
    }
}