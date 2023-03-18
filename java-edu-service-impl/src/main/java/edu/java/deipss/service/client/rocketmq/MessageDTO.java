package edu.java.deipss.service.client.rocketmq;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageDTO {
    private String name;
    private int age;
}
