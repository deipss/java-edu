package edu.java.deipss.spring.client.dubbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.java.deipss.spring.client.ClientRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DubboRequest extends ClientRequest {

    private String registryAddress;
    private String service;
    private String method;
    private String[] parameterTypes;
    private Object[] parameterList;
}
