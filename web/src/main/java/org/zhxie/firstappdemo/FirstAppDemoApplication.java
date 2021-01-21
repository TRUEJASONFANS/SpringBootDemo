package org.zhxie.firstappdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;

@SpringBootApplication
public class FirstAppDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppDemoApplication.class, args);
    }

    @Bean
    public String world() {
        return "world";
    }

    @Autowired
    public void hello(String who) {
        System.out.println("Hello " + who);
    }


    @Async
    public Future<Integer> runFuture(int i) {
        return new AsyncResult<>(i+1);
    }

    @Bean
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("MyPool");
        executor.initialize();
        return executor;
    }
}
