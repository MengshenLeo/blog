package fun.mengshenleo.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author mengshen
 * @date 2022/8/7 20:40
 */
@Configuration
@EnableScheduling
public class SchedulingTask {

    @Async
    @Scheduled(cron = "0 0 1 * * ?")
    public void testSchedule(){

        System.out.println(new Date());

    }



}
