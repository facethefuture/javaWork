package com.bbbb.spring.performanceConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages={"com.bbbb.spring.performance","com.bbbb.spring.audience"})
@Configuration
@EnableAspectJAutoProxy
public class Config {

}
