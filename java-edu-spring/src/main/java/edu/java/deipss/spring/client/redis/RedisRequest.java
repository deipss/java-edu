package edu.java.deipss.spring.client.redis;

import lombok.Data;
import edu.java.deipss.spring.client.ClientRequest;

@Data
public class RedisRequest extends ClientRequest {
    private String host;
    private String password;
    private String username;
    private String command;
    private int database;
    private int port;
}
