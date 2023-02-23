package top.otakuhuang.springbootschedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author otakuhuang
 * @version 1.0
 * @date 2023/2/23 下午2:56
 */
@Component
public class ScheduledTasks {

    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    /**
     * 时间格式
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate: 固定速率重复执行，单位：毫秒
     * 从方法开始调用时计时，每 5 秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWith5FixedRate() {
        log.info("当前时间 {}, 方法 {}",
                dateFormat.format(new Date()),
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * 每 10 秒执行一次
     */
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTimeWith10FixedRate() {
        log.info("当前时间 {}, 方法 {}",
                dateFormat.format(new Date()),
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * fixedDelay: 固定延迟时间重复执行，单位：毫秒
     * 从方法结束时开始计时，延迟 5 秒执行
     */
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeWith5FixedDelay() {
        log.info("当前时间 {}, 方法 {}",
                dateFormat.format(new Date()),
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * initialDelay: 首次执行时延迟 x 秒执行，单位：毫秒。
     * 该属性不能单独使用，需要配合 fixedRate 或 fixedDelay 等使用
     * <p>
     * 该方法首次执行时延迟 5 秒之后，之后间隔 3 秒重复执行
     */
    @Scheduled(initialDelay = 5000, fixedDelay = 3000)
    public void reportCurrentTimeWith5InitialDelay() {
        log.info("当前时间 {}, 方法 {}",
                dateFormat.format(new Date()),
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * 根据 CRON 表达式来执行
     * 每分钟的第 4 秒执行
     */
    @Scheduled(cron = "4 * * * * ? ")
    public void reportCurrentTimeWithCron() {
        log.info("当前时间 {}, 方法 {}",
                dateFormat.format(new Date()),
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
