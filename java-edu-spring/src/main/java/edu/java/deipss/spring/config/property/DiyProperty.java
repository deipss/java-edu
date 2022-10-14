package edu.java.deipss.spring.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @link to see dev.properties
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "diy.property")
@PropertySource("classpath:dev.properties")
@Validated
public class DiyProperty {

    @NotNull
    private String name;
    private String age;
    private List<Integer> nums;
}
