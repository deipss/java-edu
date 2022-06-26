package edu.java.deipss.spring.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @link to see dev.properties
 */
@Data
@Configuration
@ConfigurationProperties("")
@PropertySource("classpath:dev.properties")
public class DiyProperty {
    Map<String ,String> map;
}
