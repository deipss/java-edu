import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.spring.boot.autoconfigure.DubboAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DubboAutoConfiguration.class})
@ComponentScan("edu.java.deipss")
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
/// @EnableDubbo(scanBasePackages={"edu.java.deipss.spring.dubbo"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
