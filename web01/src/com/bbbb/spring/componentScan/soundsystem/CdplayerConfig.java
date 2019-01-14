package com.bbbb.spring.componentScan.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CdplayerConfig {
	@Bean
	public Cd1 cd1(){
		return new Cd1();
	}

}
