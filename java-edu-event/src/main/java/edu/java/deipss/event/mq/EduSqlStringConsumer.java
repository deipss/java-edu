package edu.java.deipss.event.mq;

import edu.java.deipss.service.test.domain.mq.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;

import static edu.java.deipss.service.test.domain.mq.TopicConstant.EDU_TOPIC_1;
import static edu.java.deipss.service.test.domain.mq.TopicConstant.EDU_TOPIC_GROUP;

@Slf4j
/// @Service
@RocketMQMessageListener(topic = EDU_TOPIC_1,
        consumerGroup = EDU_TOPIC_GROUP+2,
        selectorType = SelectorType.SQL92,
        selectorExpression = "age>50")
// Caused by: org.apache.rocketmq.client.exception.MQClientException: CODE: 1  DESC: The broker does not support consumer to filter message by SQL92
public class EduSqlStringConsumer implements RocketMQListener<MessageDTO> {
    @Override
    public void onMessage(MessageDTO message) {
        log.info("EduSqlStringConsumer 获取MQ消息={}", message);


    }
}