package com.sun.springbootTest.controller;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqTestController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	RabbitMessagingTemplate rb;
	@RequestMapping("/rabbit")
	public String rabbit() {
	
	//rabbitTemplate.setQueue("hello");
	//rabbitMessagingTemplate.convertAndSend("amq.topic", "sun.test", "it is ok");
	try {
		rabbitTemplate.convertAndSend("amq.topic", "sun.test", "it is ok");
	} catch (AmqpException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	
		return "ok";
	}

}
