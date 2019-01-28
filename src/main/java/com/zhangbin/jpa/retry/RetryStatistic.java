package com.zhangbin.jpa.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.RetryStatistics;
import org.springframework.retry.stats.DefaultStatisticsRepository;
import org.springframework.retry.stats.StatisticsListener;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryStatistic {

    public void getRetryStatistic() {
        RetryTemplate template = new RetryTemplate();
        DefaultStatisticsRepository repository = new DefaultStatisticsRepository();
        StatisticsListener listener = new StatisticsListener(repository);
        template.setListeners(new RetryListener[]{listener});
        for (int i = 0; i < 10; i++) {
            String result = template.execute(new RetryCallback<String, RuntimeException>() {
                @Override
                public String doWithRetry(RetryContext context) throws RuntimeException {
                    context.setAttribute(RetryContext.NAME, "method.key");
                    return "ok";
                }
            });
        }

        RetryStatistics statistics = repository.findOne("method.key");
        System.out.println(statistics);
    }
}
