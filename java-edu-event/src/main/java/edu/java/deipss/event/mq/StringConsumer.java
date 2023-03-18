package edu.java.deipss.event.mq;

import edu.java.deipss.service.test.domain.mq.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import static edu.java.deipss.service.test.domain.constant.TopicConstant.*;

@Slf4j
@Service
@RocketMQMessageListener(topic = EDU_TOPIC_1,
        consumerGroup = EDU_TOPIC_GROUP,
        selectorExpression = EDU_TAG_1)
public class StringConsumer implements RocketMQListener<MessageDTO> {
    @Override
    public void onMessage(MessageDTO message) {
        log.info("获取消息={}", message);
    }
}