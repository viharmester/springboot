package com.andorid.l2pp.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@PropertySource("application-${spring.profiles.active}.yml")
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class Application {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
