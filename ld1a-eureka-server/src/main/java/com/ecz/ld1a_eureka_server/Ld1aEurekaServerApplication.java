package com.ecz.ld1a_eureka_server;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ld1aEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ld1aEurekaServerApplication.class, args);
	}

}
