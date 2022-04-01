package com.lnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.lnt"})
@EntityScan({"com.lnt.entity"})

public class ShoppEApp {

	public static void main(String[] args) {
		SpringApplication.run(ShoppEApp.class, args);
		
	}

}


