package com.bbbb.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbbb.spring.componentScan.soundsystem.ICompactDisc;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=com.bbbb.spring.componentScan.soundsystem.CdplayerConfig.class)
public class MyTest {
	@Autowired
	private ICompactDisc cd;
	@Test
	public void test(){
//		ApplicationContext ctx = new ClasspathXmlApplicationContext();
		cd.play();
	}
}
