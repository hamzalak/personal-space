package com.grokonez.jwtauthentication;

import com.grokonez.jwtauthentication.controller.AuthRestAPIs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.grokonez.jwtauthentication.security"})
@ComponentScan(basePackageClasses = AuthRestAPIs.class)
public class SpringBootJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);

	}
}
