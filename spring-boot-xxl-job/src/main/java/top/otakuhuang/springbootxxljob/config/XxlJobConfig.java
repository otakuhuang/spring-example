package top.otakuhuang.springbootxxljob.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Xxl-Job 执行器配置类
 * @author otakuhuang
 * @version 1.0
 * @date 2023/2/23 下午9:58
 */
@Configuration
public class XxlJobConfig {

    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Autowired
    private XxlJobConfigProperties properties;

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor() {
        logger.info(">>>>> xxl-job 配置初始化. <<<<<");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(properties.getAdmin().getAddress());
        xxlJobSpringExecutor.setAppname(properties.getExecutor().getAppname());
        xxlJobSpringExecutor.setAddress(properties.getExecutor().getAddress());
        xxlJobSpringExecutor.setIp(properties.getExecutor().getIp());
        xxlJobSpringExecutor.setAccessToken(properties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(properties.getExecutor().getLogpath());
        xxlJobSpringExecutor.setLogRetentionDays(properties.getExecutor().getLogretentiondays());
        return xxlJobSpringExecutor;
    }

}
