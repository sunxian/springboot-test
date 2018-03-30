package com.sun.springbootTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	//远程redis默认阻止连接
	//redis-cli后 输入CONFIG SET protected-mode no
	@Autowired
    StringRedisTemplate redisTemplate;
	
	@RequestMapping("/sun")
	public String s() {
		
		redisTemplate.opsForValue().set("sun", "123");		
		
		return "ok";
		
	}

}
