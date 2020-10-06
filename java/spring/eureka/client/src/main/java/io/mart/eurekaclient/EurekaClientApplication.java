package io.mart.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
/**
 * Spring Cloud supports multiple discovery solutions such as
 * Eureka, Consul, Zookeeper and Cloud Foundry.
 * The @EnableDiscoveryClient instructs Spring Boot to scan
 * the classpath and identify the service discovery implementation
 * used (In this case Eureka as spring-cloud-starter-netflix-eureka-server dependency is used).
 * Afterwards, Spring Boot activates DicoveryClient implementation
 * and register the service name and the corresponding network location
 * in the Eureka server.
 *
 * There is another annotation namely @EnableEurekaClient
 * that you can use to create an Eureka client application.
 * In contrast to @EnableDiscoveryClient , @EnableEurekaClient can only be used with Eureka.
 */
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
