package edu.java.deipss.common.serizlized;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class TransientTest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class InnerBO{
        private String name;
        private int age;
        private transient int temp;
    }

    @Test
    public void test(){
        InnerBO innerBO = new InnerBO();
        innerBO.setName("1");
        innerBO.setAge(1);
        innerBO.setTemp(99);
        System.out.println(JSON.toJSONString(innerBO));
    }
}
