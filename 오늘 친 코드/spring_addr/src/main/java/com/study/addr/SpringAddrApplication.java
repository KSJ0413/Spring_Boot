package com.study.addr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.study.*"})
public class SpringAddrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAddrApplication.class, args);
	}

}
