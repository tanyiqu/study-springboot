package love.tanyiqu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Boot08ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot08ScheduledApplication.class, args);
    }

}
