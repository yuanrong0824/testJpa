package com.zhangbin.jpa.service;

import com.zhangbin.jpa.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * mark
 *
 * @Author: liuqing
 * @Date: 2019-01-21 21:31
 * @Version 1.0
 */
@Service
@Slf4j
public class SpringRetryService {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))
    public void retry() {

        log.info("执行的次数:{}", atomicInteger.incrementAndGet());
        long start = System.currentTimeMillis();
        log.info("执行的开始时间:{}", DateUtil.formatLongDate(new Date(start)));
        int i = 1 / 0;
    }

    @Recover
    public void recover(Exception e) {
        log.error("程序异常:{}", e);
    }
}
