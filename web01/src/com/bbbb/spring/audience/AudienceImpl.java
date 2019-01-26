package com.bbbb.spring.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceImpl implements IAudience{
	@Pointcut("execution(* com.bbbb.spring.performance.PerformanceImpl.perform())")
	public void perform(){};
	@Before("perform()")
	public void keepScience(){
		System.out.println("表演前关闭手机");
	}
	@After("perform()")
	public void applaud() {
		System.out.println("节目很精彩，鼓掌");
	}
	@Around("perform()")
	public void watchPerormance(ProceedingJoinPoint jp){
		try{
			System.out.println("表演前请关闭手机");
			System.out.println("请就坐");
			jp.proceed();
			System.out.println("表演结束了，鼓掌");
		} catch(Throwable e){
			e.printStackTrace();
			System.out.println("表演不好看  要退款");
		}
	}
	@Pointcut("execution(* com.bbbb.spring.performance.PerformanceImpl.perform(int)) && args(number)")
	public void perform2(int number){}
	@Before("perform2(number)")
	public void count(int number){
		System.out.println(number);
	}
}
