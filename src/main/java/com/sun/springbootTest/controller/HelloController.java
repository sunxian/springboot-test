package com.sun.springbootTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.springbootTest.entity.User;

@RestController
public class HelloController {
	Logger log=LoggerFactory.getLogger(HelloController.class);
	
	//远程redis默认阻止连接
	//redis-cli后 输入CONFIG SET protected-mode no
	@Autowired
    StringRedisTemplate redisTemplate;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/sun")
	public String s() {
		
		redisTemplate.opsForValue().set("sun", "123");	
		User u=new User();
		u.setAge(10);
		u.setName("tom");
		Jackson2JsonRedisSerializer<User> u1=new Jackson2JsonRedisSerializer<User>(User.class);
		byte[] b=u1.serialize(u);
		User user=u1.deserialize(b);
		log.info("s:",user.toString());
		log.info(new String(b));
		redisTemplate.opsForValue().set("json", new String(b));
		//JdkSerializationRedisSerializer s=new JdkSerializationRedisSerializer();
		
		
		//JdkSerializationRedis Serializer RedisCache,RedisTemplate默认
		//rediscallback
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				((StringRedisConnection)connection).set("1", "1");
				return null;
			}
		});
		return "ok";
		
	}

}
