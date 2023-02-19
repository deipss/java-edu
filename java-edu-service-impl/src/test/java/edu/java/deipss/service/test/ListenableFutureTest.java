package edu.java.deipss.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class ListenableFutureTest {

    /**
     * spring DigestUtils 测试
     */
    @Test
    public void test() {
        byte[] bytes = DigestUtils.md5Digest("123".getBytes(StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder("1mj23");
        DigestUtils.appendMd5DigestAsHex(bytes, stringBuilder);
        System.out.println(stringBuilder);
    }
}
