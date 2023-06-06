package edu.java.deipss.common.pattern.chain;


import org.springframework.stereotype.Component;

@Component
public class ChainTestEngine extends ChainEngine<String>{

    public static final String CHAIN_TEST_ENGINE = "ChainTestEngine";

    public ChainTestEngine() {
        super(CHAIN_TEST_ENGINE);
    }
}
