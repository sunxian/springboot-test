package com.sun.springbootTest;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableRabbit
public class Config {
  

final static String queueName = "hello";
    
    final static String HOST = "gdc-nba-api-01.offline.hupu.com";

    final static String USERNAME = "guest";
    
    final static String PASSWORD = "guest";

    final static int PORT = 5672;
    
    @Bean
    Queue queue() {
        return new Queue(queueName,true,false, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("amq.topic");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("sun.*");
    }

@Bean  
    public ConnectionFactory connectionFactory() {  
    	  CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
          connectionFactory.setHost(HOST);
          connectionFactory.setPort(PORT);
          connectionFactory.setUsername(USERNAME);
          connectionFactory.setPassword(PASSWORD);
         // connectionFactory.setVirtualHost("/");
          //必须要设置,消息的回掉
          connectionFactory.setPublisherConfirms(true); 
          return connectionFactory;
    }

@Bean 
public RabbitTemplate producerMainRabbitTemplate()
{
    RabbitTemplate template = new RabbitTemplate();
    template.setConnectionFactory(connectionFactory());
    //template.setExchange("amq.topic");
    //template.setRoutingKey("");
    return template;
}
}
