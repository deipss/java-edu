package edu.java.deipss.service.client.dubbo;

import edu.java.deipss.service.client.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
