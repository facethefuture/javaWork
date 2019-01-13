package com.bbbb.spring.componentScan.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CompactSiscImpl implements ICompactDisc{
	public void play() {
		System.out.println("播放cd");
		
	}

}
