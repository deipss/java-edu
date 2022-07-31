package edu.java.deipss.spring.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.ApplicationEvent;

public class QueryEvent  extends ApplicationEvent {

    @Data
    @AllArgsConstructor
    public static class QueryEventData{
        private String name;
        private String data;
    }

    public QueryEvent(QueryEventData source) {
        super(source);
    }
}
