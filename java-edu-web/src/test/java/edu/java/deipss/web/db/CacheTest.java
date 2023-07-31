package edu.java.deipss.web.db;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CacheTest {

    Cache<String,String> caffeine = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .expireAfterAccess(10,TimeUnit.SECONDS)
            .removalListener((k,v,e)->{
                System.out.printf("k=%s,v=%s,e=%s\n",k,v,e);
            })
            .initialCapacity(1<<4)
            .build();

    @Test
    @SneakyThrows
    public void test(){
        caffeine.put("Test","Test");
        TimeUnit.SECONDS.sleep(6L);
        String test = caffeine.getIfPresent("Test");
        System.out.println(test);


        caffeine.put("Test","test2");
        String test2 = caffeine.getIfPresent("Test");
        TimeUnit.SECONDS.sleep(9L);
        System.out.println(test2);
        TimeUnit.SECONDS.sleep(10L);
        System.out.println(test2);

    }
}
