package com.springboot.expencemanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpencemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpencemanagerApplication.class, args);
        ExecutorService excutorService = Executors.newFixedThreadPool(2);
        Runnable task1 = new Runnable() {
            
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("My task1 started...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("My task1 end...");
            }
        };
        excutorService.submit(task1);
        excutorService.shutdown();
    }

}
