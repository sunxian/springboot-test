package com.sun.springbootTest.entity;

import java.util.Optional;

/**
 * @author sunxian
 * 人
 */
public class Person {
	private Long id;
	private String name;
	private Integer age;
	private Optional<Car> car;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Optional<Car> getCar() {
		return car;
	}
	public void setCar(Optional<Car> car) {
		this.car = car;
	}
	
}
