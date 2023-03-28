package edu.java.deipss.sql.config.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "es")
@Data
@NoArgsConstructor
@Component
public class EsConfigProperty {
    private String host;
    private String pwd;
    private String user;
    private String port;
}
