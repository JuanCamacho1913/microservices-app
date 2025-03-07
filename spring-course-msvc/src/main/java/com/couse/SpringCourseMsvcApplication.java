package com.couse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCourseMsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseMsvcApplication.class, args);
	}

}
