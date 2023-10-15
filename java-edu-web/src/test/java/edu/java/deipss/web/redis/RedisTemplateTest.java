package edu.java.deipss.web.redis;

import edu.java.deipss.sql.config.SpringRedisConfig;
import edu.java.deipss.web.BaseTest;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest(classes = {SpringRedisConfig.class, RedisProperties.class})
@EnableAsync
public class RedisTemplateTest extends BaseTest {

    @Autowired
    @Qualifier(SpringRedisConfig.DEFAULT_REDIS_TEMPLATE)
    private RedisTemplate redisTemplate;


    @Test
    public void testHash(){
        redisTemplate.opsForHash().put("Bob:100","name","Bob");
        Object name = redisTemplate.opsForHash().get("Bob:100", "name");
        System.out.println(name);
    }

    @Test
    public void testNull(){
        redisTemplate.opsForValue().set("","Null",10, TimeUnit.MINUTES);
    }

    @Test
    public void testGeo(){
        /**
         * Valid longitudes are from -180 to 180 degrees.
         * Valid latitudes are from -85.05112878 to 85.05112878 degrees.
         */
        List<RedisGeoCommands.GeoLocation> geoLocations = new ArrayList<>(4);
        geoLocations.add( new RedisGeoCommands.GeoLocation<String>("StoreA",new Point(11,76.43434)));
        geoLocations.add( new RedisGeoCommands.GeoLocation<String>("StoreB",new Point(-4.34343,4)));
        geoLocations.add( new RedisGeoCommands.GeoLocation<String>("StoreC",new Point(87,34)));
        geoLocations.add( new RedisGeoCommands.GeoLocation<String>("StoreD",new Point(-23,65)));
        Long add = redisTemplate.opsForGeo().add("STORE_TEST",geoLocations);
        System.out.println(add);

        Distance distance1 = redisTemplate.opsForGeo().distance("STORE_TEST", "StoreA", "StoreA");
        Distance distance2 = redisTemplate.opsForGeo().distance("STORE_TEST", "StoreA", "StoreD");
        System.out.println(distance1.getNormalizedValue());
        System.out.println(distance2.getNormalizedValue());

    }

    @Test
    @SneakyThrows
    public void testBitMap(){
        String keyPrefix = "TEST_SIGN_SECOND";
        redisTemplate.opsForValue().setBit(keyPrefix, LocalTime.now().getSecond(),true);
        TimeUnit.SECONDS.sleep(1L);
        redisTemplate.opsForValue().setBit(keyPrefix, LocalTime.now().getSecond(),true);
        TimeUnit.SECONDS.sleep(1L);
        redisTemplate.opsForValue().setBit(keyPrefix, LocalTime.now().getSecond(),true);
        TimeUnit.SECONDS.sleep(1L);
        redisTemplate.opsForValue().setBit(keyPrefix, LocalTime.now().getSecond(),true);




    }

    @Test
    @SneakyThrows
    public void testPip(){

    }
}
