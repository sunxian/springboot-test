package com.sun.springbootTest.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author sunxian
 * @RabbitListener @RabbitHandler 搭配使用
 */
@Component
@RabbitListener(queues="hello")
public class MqReceivingBean {
	
	
	@RabbitHandler
	public void processMessage(String text){
		System.out.println("Receiver:"+text);
	}

}
