package com.zhangbin.jpa.aspect;

import com.zhangbin.jpa.retry.RetryTemplate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class RetryAspect {

    ExecutorService executorService = new ThreadPoolExecutor(3, 5,
            1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());


    @Around(value = "@annotation(retryDot)")
    public Object execute(ProceedingJoinPoint joinPoint, RetryDot retryDot) throws Exception {
        RetryTemplate retryTemplate = new RetryTemplate() {
            @Override
            protected Object doBiz() throws Exception {
                Object proceed = null;
                try {
                    proceed = joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    throw new RuntimeException();
                }
                return proceed;
            }
        };
        retryTemplate.setRetryTime(retryDot.count());
        retryTemplate.setSleepTime(retryDot.sleep());
        if (retryDot.asyn()) {
            return retryTemplate.submit(executorService);
        } else {
            return retryTemplate.execute();
        }
    }
}