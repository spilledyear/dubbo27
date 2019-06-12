package com.sxy.sdubbo;

import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDubbo
public class SDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(SDubboApplication.class, args);
    }


    @Configuration
    @PropertySource("classpath:/dubbo-provider.properties")
    static class ProviderConfiguration {
        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
//            registryConfig.setAddress("nacos://10.9.44.133:8848");
//            registryConfig.setAddress("multicast://224.5.6.7:1234");
            registryConfig.setAddress("zookeeper://10.9.44.133:2181");

            // 注册简化版的的url到注册中心
            registryConfig.setSimplified(true);
            return registryConfig;
        }


        @Bean
        public MetadataReportConfig metadataReportConfig() {
            MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
//            metadataReportConfig.setAddress("nacos://10.9.44.133:8848");
            metadataReportConfig.setAddress("zookeeper://10.9.44.133:2181");
//            metadataReportConfig.setAddress("redis://localhost:6379");
            return metadataReportConfig;
        }


        @Bean
        public ConfigCenterConfig configCenterConfig() {
            ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
//            configCenterConfig.setAddress("nacos://10.9.44.133:8848");
            configCenterConfig.setAddress("zookeeper://10.9.44.133:2181");
            return configCenterConfig;
        }
    }

}
