package edu.java.deipss.common.cypher;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.apache.commons.codec.Charsets;
import org.junit.Test;

/**
 * 加密测试
 */
public class CypherTest {

    private String plaintText="测试文件12321bsdfSsdfsd";

    private String cypher="Java@c1024noipDD";

    /**
     * 对称加密
     */
    @Test
    public void test(){
        AES aes = SecureUtil.aes(cypher.getBytes(Charsets.toCharset("utf-8")));
        String encrypt = aes.encryptHex(plaintText.getBytes());
        System.out.println(encrypt);
        System.out.println(aes.decryptStr(encrypt));
    }
}
