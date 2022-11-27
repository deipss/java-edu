package edu.java.deipss.spring.client;


public interface BaseClient<T extends ClientRequest> {

    Object execute(T request);
}
