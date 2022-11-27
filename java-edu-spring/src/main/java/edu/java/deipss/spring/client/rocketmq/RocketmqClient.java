package edu.java.deipss.spring.client.rocketmq;


import lombok.extern.slf4j.Slf4j;
import edu.java.deipss.spring.client.BaseClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RocketmqClient implements BaseClient<RocketmqRequest> {

    @Override
    public Object execute(RocketmqRequest request) {
        DefaultMQProducer producer = new DefaultMQProducer(request.getGroup());
        producer.setNamesrvAddr(request.getNamespace());
        try {
            producer.start();
            Message message = new Message();
            message.setBody(request.getMsg().getBytes());
            message.setTopic(request.getTopic());
            message.setTags(request.getTags());
            SendResult send = producer.send(message);
            return send;
        }catch (Exception e){
            log.error("rocket mq error",e);
        }finally {
            producer.shutdown();
        }
        return null;
    }
}