package com.bbbb.spring.student;

public class Student {
	private int id;
	private String name;
	private int age;
	public Student(int id,String name){
		this.id = id;
		this.name = name;
	}
	public Student(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
}
