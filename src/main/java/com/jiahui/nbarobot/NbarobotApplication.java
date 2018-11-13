package com.jiahui.nbarobot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dongjiahui
 */
@SpringBootApplication
@MapperScan("com.jiahui.nbarobot")
@ComponentScan("com.jiahui.nbarobot")
public class NbarobotApplication {

	public static void main(String[] args) {

		SpringApplication.run(NbarobotApplication.class, args);
	}
}
