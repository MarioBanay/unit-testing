package com.mariobanay.npp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mariobanay.npp.aspects.ExceptionAspect;
import com.mariobanay.npp.aspects.LoggerAspect;

@Configuration
@ComponentScan("com.mariobanay.npp")
public class SpringConfig {
	
	@Bean
	public LoggerAspect logger() {
		return new LoggerAspect();
	}
	
	@Bean
	public ExceptionAspect exception() {
		return new ExceptionAspect();
	}
}
