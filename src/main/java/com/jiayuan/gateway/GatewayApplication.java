package com.jiayuan.gateway;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class GatewayApplication {
	private final static Logger log = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {

//		SpringApplication.run(GatewayApplication.class, args);

		MDC.put("traceRootId", RandomStringUtils.randomAlphanumeric(32));
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GatewayApplication.class, args);

		ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
		log.info("当前使用的配置中心和注册中心地址是：{}", environment.getProperty("spring.cloud.nacos.discovery.server-addr"));
		log.info("当前使用的namespace是：{}", environment.getProperty("spring.cloud.nacos.discovery.namespace"));
	}

}
