package edu.java.deipss.service.client.rocketmq;

import edu.java.deipss.service.test.domain.mq.MessageDTO;
import edu.java.deipss.service.test.domain.mq.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.UUID;

import static edu.java.deipss.service.test.domain.mq.TopicConstant.EDU_TOPIC_DELAY_1;


@Slf4j
@Component
public class MqTemplateProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 延时发送
     */
    public void producerDelay() {
        // 同步发送延迟消息，延迟level为9，即5分钟。
        rocketMQTemplate.syncSend(EDU_TOPIC_DELAY_1, MessageBuilder.withPayload("hello delay msg").build(), 1000, 9);

    }


    /**
     * 发送单向消息，不关注发送的结果
     * public void sendOneWay(String destination, Message<?> message)
     * 结果是空
     */
    public void producerOneWay() {
        rocketMQTemplate.sendOneWay(EDU_TOPIC_DELAY_1, MessageBuilder.withPayload("hello delay msg one way ").build());

    }


    /**
     * 异步发送
     */
    public void producerAsync() {

        MessageDTO dto = MessageDTO.builder().name("test_async").age(LocalTime.now().getNano() % 100).build();

        // 异步发送消息
        rocketMQTemplate.asyncSend(TopicConstant.EDU_TOPIC_1, dto, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("async onSuccess SendResult={}} ", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                log.info("async onException Throwable", e);
            }

        });
    }

    public void sendWithTags(){
        MessageDTO dto = MessageDTO.builder().name("test").age(LocalTime.now().getNano() % 100).build();
        dto.setAddress("湖南省长沙市区"+LocalTime.now().getNano()%100);
        // 发送消息时指定TAG，通过destination参数指定，格式为topicName:tagName
        rocketMQTemplate.convertAndSend(TopicConstant.EDU_TOPIC_1 + ":" + TopicConstant.EDU_TAG_1, dto);

    }

    @Async("executeThreadPoolExecutor")
    public void producer() {

        MessageDTO dto = MessageDTO.builder().name("test").age(LocalTime.now().getNano() % 100).build();
        // 同步发送消息
        rocketMQTemplate.convertAndSend(TopicConstant.EDU_TOPIC_1, dto);


        // 发送消息时如何设置消息的key,可以通过重载的xxxSend(String destination, Message<?> msg, ...)方法来发送消息，指定msg的headers来完成
        String msgId = UUID.randomUUID().toString();
        rocketMQTemplate.send(TopicConstant.EDU_TOPIC_1, MessageBuilder.withPayload("msg of key").setHeader(MessageConst.PROPERTY_KEYS, msgId).build());

        // 发送顺序排序消息
        SendResult sendResult = rocketMQTemplate.syncSendOrderly(TopicConstant.EDU_TOPIC_1, MessageBuilder.withPayload("Hello, World").build(), "hashkey");
        log.info("发送结果sendResult={}", sendResult.getMsgId());


        // 销毁rocketMQTemplate,注意：一旦销毁，就不能再使用rocketMQTemplate发送消息
        // 不需要手动执行此方法，rocketMQTemplate会在spring容器销毁时自动销毁
        //rocketMQTemplate.destroy();
    }
}