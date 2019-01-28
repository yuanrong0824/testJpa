package com.zhangbin.jpa.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@Slf4j
public class RetryDemo {

    private static final ExecutorService executorService= Executors.newFixedThreadPool(10);
    public void retryDemo() throws InterruptedException {
        Object ans = new RetryTemplate() {
            @Override
            protected Object doBiz() throws Exception {
                int temp = (int) (Math.random() * 100);
                System.out.println(temp);
                if (temp > 3) {
                    throw new Exception("generate value bigger then 3! need retry");
                }
                return temp;
            }
        }.setRetryTime(10).setSleepTime(10000).submit(executorService);
        System.out.println(ans);
    }
}
