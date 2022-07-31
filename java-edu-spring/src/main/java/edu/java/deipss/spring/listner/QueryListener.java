package edu.java.deipss.spring.listner;

import edu.java.deipss.spring.event.QueryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryListener implements ApplicationListener<QueryEvent> {
    @Override
    public void onApplicationEvent(QueryEvent queryEvent) {
        log.info("监听到事件QueryEvent={}", queryEvent.getSource());
    }
}
