package springtest;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.sun.springbootTest.Server;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Server.class)
@WebAppConfiguration
public class MqSendTest {
	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Test
	 public void send() {
	        String context = "hello " + new Date();
	       // System.out.println("Sender : " + context);
	       amqpTemplate.convertAndSend("sun.test", "okkkkkk");
	        //rabbitMessagingTemplate.convertAndSend("amq.topic", "sun.test", "send success");
	        
	    }
	
	
	

}
