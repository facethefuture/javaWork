package com.bbbb.spring.performance;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements IPerformance{
	public void perform(){
		System.out.println("表演啦啦啦");
	}
	public void perform(int n){
		System.out.println(n);
	}
}
