package edu.java.deipss.service.client.redis;

import edu.java.deipss.service.client.ClientRequest;
import lombok.Data;

@Data
public class RedisRequest extends ClientRequest {
    private String host;
    private String password;
    private String username;
    private String command;
    private int database;
    private int port;
}
