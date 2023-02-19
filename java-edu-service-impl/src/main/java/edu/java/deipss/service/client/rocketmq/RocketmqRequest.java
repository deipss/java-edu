package edu.java.deipss.service.client.rocketmq;

import edu.java.deipss.service.client.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
