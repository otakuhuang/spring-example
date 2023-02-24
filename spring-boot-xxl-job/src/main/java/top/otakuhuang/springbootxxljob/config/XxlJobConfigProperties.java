package top.otakuhuang.springbootxxljob.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job 配置参数
 *
 * @author otakuhuang
 * @version 1.0
 * @date 2023/2/23 下午10:03
 */
@Configuration
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobConfigProperties {

    @NestedConfigurationProperty
    private Admin admin;
    private String accessToken;
    @NestedConfigurationProperty
    private Executor executor;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    static class Admin {
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    static class Executor {
        private String appname;
        private String address;
        private String ip;
        private Integer port;
        private String logpath;
        private Integer logretentiondays;

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getLogpath() {
            return logpath;
        }

        public void setLogpath(String logpath) {
            this.logpath = logpath;
        }

        public Integer getLogretentiondays() {
            return logretentiondays;
        }

        public void setLogretentiondays(Integer logretentiondays) {
            this.logretentiondays = logretentiondays;
        }
    }
}
