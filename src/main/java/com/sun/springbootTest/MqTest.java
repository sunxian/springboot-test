package com.sun.springbootTest;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

public class MqTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ConnectionFactory cf=new CachingConnectionFactory();
		ConnectionFactory cf=new CachingConnectionFactory("gdc-nba-api-01.offline.hupu.com", 5672);
		RabbitAdmin admin =new RabbitAdmin(cf);
		Queue queue = new Queue("myQueue");
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange("myExchange");
		admin.declareExchange(exchange);
		admin.declareBinding(
			BindingBuilder.bind(queue).to(exchange).with("sun.*"));
		SimpleMessageListenerContainer container =
				new SimpleMessageListenerContainer(cf);
		Object listener = new Object() {
			public void handleMessage(String foo) {
				System.out.println(foo);
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames("myQueue");
		container.start();

		// send something
		RabbitTemplate template = new RabbitTemplate(cf);
		template.convertAndSend("myExchange", "sun.test", "Hello, world amq!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		container.stop();
	}

}
