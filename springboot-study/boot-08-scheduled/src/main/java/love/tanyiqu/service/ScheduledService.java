package love.tanyiqu.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 每分钟的第0秒执行
    @Scheduled(cron = "0 * * * * ?")
    public void scheduled() {
        System.out.println("被执行了");
    }

    // 每2秒执行
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduled2() {
        System.out.println("scheduled2");
    }

}
