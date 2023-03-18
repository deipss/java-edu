package edu.java.deipss.service.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

public class QueryEvent extends ApplicationEvent {

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
