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
        // 应该获取不到，因为写入5秒后过期
        caffeine.put("Test","Test");
        TimeUnit.SECONDS.sleep(6L);
        String test = caffeine.getIfPresent("Test");
        System.out.println(test);

        caffeine.put("Test2","test2");
        TimeUnit.SECONDS.sleep(4L);
        String test2 = caffeine.getIfPresent("Test2");
        System.out.println(test2);
        // 先读，等待12秒，应该会过期，
        TimeUnit.SECONDS.sleep(12L);
        test2 = caffeine.getIfPresent("Test2");
        System.out.println(test2);

    }
}
