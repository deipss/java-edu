package edu.java.deipss.event.job;

import edu.java.deipss.service.client.rocketmq.MqTemplateProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/// @Component
@Slf4j
public class MQSendJob {


    @Autowired
    private MqTemplateProducer mqTemplateProducer;

    @Scheduled(cron = "0/10 * * * * ?")
    public void templateProducer() {
        mqTemplateProducer.producer();
        mqTemplateProducer.producerAsync();
        mqTemplateProducer.producerDelay();
    }
}
