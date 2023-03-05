package edu.java.deipss.common.hutool;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.system.SystemUtil;
import com.google.common.base.Charsets;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 加密测试 hutool工具
 */
public class HuToolTest {

    private final String plaintText = "测试文件12321bsdfSsdfsd";

    /**
     * 密钥长度为16
     */
    private final String cypher = "Java@c1024noipDD";

    /**
     * 对称加密
     */
    @Test
    public void cypherTest() {
        AES aes = SecureUtil.aes(cypher.getBytes(Charsets.UTF_8));
        String encrypt = aes.encryptHex(plaintText.getBytes());
        System.out.println(encrypt);
        System.out.println(aes.decryptStr(encrypt));
    }

    /**
     * 三个部分是 base64url 编码的
     * HEADER
     * PAYLOAD
     * 签名
     */
    @Test
    public void JWTTest() {
        // 生成token
        Map<String, Object> payLoad = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        String token = JWTUtil.createToken(payLoad, "1234".getBytes());
        System.out.println(token);

        // 解析token
        final JWT jwt = JWTUtil.parseToken(token);

        Object header = jwt.getHeader(JWTHeader.TYPE);
        System.out.println(header);
        Object sub = jwt.getPayload("sub");
        System.out.println(sub);
        System.out.println(jwt.getPayloads());
        // 验证token

        System.out.println(JWTUtil.verify(token, "123456".getBytes()));
        System.out.println(JWTUtil.verify(token, "1234".getBytes()));
    }


    @Test
    public void systemTest() {
        System.out.println(SystemUtil.getOsInfo());

        System.out.println(SystemUtil.getJvmInfo());


        System.out.println(SystemUtil.getJavaSpecInfo());


        System.out.println(SystemUtil.getUserInfo());


        System.out.println(SystemUtil.getHostInfo());


        System.out.println(SystemUtil.getRuntimeInfo());
    }

}
