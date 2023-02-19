package edu.java.deipss.event.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

public class QueryEventBO extends ApplicationEvent {

    @Data
    @AllArgsConstructor
    public static class QueryEventData{
        private String name;
        private String data;
    }

    public QueryEventBO(QueryEventData source) {
        super(source);
    }
}
