package edu.java.deipss.service.client.rocketmq;

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

@Component
public class TemplateProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Async("executeThreadPoolExecutor")
    public void producer() {

        MessageDTO dto = MessageDTO.builder().name("test").age(LocalTime.now().getNano() % 100).build();
        // 同步发送消息
        rocketMQTemplate.convertAndSend(TopicConstant.EDU_TOPIC_1, dto);
        // 异步发送消息
        rocketMQTemplate.asyncSend(TopicConstant.EDU_TOPIC_1, dto, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.printf("async onSucess SendResult=%s %n", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.printf("async onException Throwable=%s %n", e);
            }

        });

        // 发送消息时指定TAG，通过destination参数指定，格式为topicName:tagName
        rocketMQTemplate.convertAndSend(TopicConstant.EDU_TOPIC_1+":"+TopicConstant.EDU_TAG_1, dto);

        //send spring message,Message参数包为: org.springframework.messaging.Message
        rocketMQTemplate.send(TopicConstant.EDU_TOPIC_1, MessageBuilder.withPayload("Hello, World! I'm from spring message").build());

        // 发送消息时如何设置消息的key,可以通过重载的xxxSend(String destination, Message<?> msg, ...)方法来发送消息，指定msg的headers来完成
        String msgId = UUID.randomUUID().toString();
        rocketMQTemplate.send("topic-test", MessageBuilder.withPayload("msg of key").setHeader(MessageConst.PROPERTY_KEYS, msgId).build());

        // 发送顺序排序消息
        rocketMQTemplate.syncSendOrderly("orderly_topic", MessageBuilder.withPayload("Hello, World").build(), "hashkey");

        // 同步发送延迟消息，延迟levle为9，即5分钟。
        rocketMQTemplate.syncSend("delay-topic", MessageBuilder.withPayload("hello delay msg").build(), 1000, 9);

        // 销毁rocketMQTemplate,注意：一旦销毁，就不能再使用rocketMQTemplate发送消息
        // 不需要手动执行此方法，rocketMQTemplate会在spring容器销毁时自动销毁
        //rocketMQTemplate.destroy();
    }
}