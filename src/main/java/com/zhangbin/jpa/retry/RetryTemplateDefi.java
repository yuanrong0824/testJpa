package com.zhangbin.jpa.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RetryTemplateDefi {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public void getTimeoutRetryPolicy() {
        RetryTemplate template = new RetryTemplate();
        TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(30000L);
        template.setRetryPolicy(policy);
        RetryCallback<String, RuntimeException> retryCallback = context -> {
            System.out.println("重复执行策略:{}" + atomicInteger.incrementAndGet());
            int x = 1 / 0;
            return "1";
        };
        return;
    }
}
