package com.zhangbin.jpa.retry;

import com.zhangbin.jpa.aspect.RetryDot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class RetryAspectDemo {

    @RetryDot(count = 3,sleep=6000,asyn = true)
    public void retryAspectDemo() throws RuntimeException {
        int i = 1 / 0;
        System.out.println(1111);
    }
}
