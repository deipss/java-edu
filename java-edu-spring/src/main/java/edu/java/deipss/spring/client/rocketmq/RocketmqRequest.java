package edu.java.deipss.spring.client.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.java.deipss.spring.client.ClientRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RocketmqRequest extends ClientRequest {
        private String namespace;
        private String group;
        private String msg;
        private String topic;
        private String tags;
}
