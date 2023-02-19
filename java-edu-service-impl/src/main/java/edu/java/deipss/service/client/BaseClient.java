package edu.java.deipss.service.client;


public interface BaseClient<T extends ClientRequest> {

    Object execute(T request);
}
