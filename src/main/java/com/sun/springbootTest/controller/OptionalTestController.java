package com.sun.springbootTest.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.springbootTest.entity.Car;
import com.sun.springbootTest.entity.Person;

@RestController
public class OptionalTestController {
	@RequestMapping("/test/1")
	public Integer getCarPriice(){
		Person p=new Person();
		p.setAge(17);
		Car car=new Car();
		//car.setColor("red");
		Optional<Car> c=Optional.of(car);
		//p.setCar(c);
		Optional<Person> person=Optional.ofNullable(p);
		return person.flatMap(Person::getCar).map(Car::getPrice).orElse(0);
		
	}
	
	@RequestMapping("/test/2")
	public Person getCar(){
		Person p=new Person();
		p.setAge(17);
		Car car=new Car();
		//car.setColor("red");
		
		return p;
		
	}

}
