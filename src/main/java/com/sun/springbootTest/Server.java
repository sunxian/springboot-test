package com.sun.springbootTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * start class
 *
 */
@SpringBootApplication
@RestController
@EnableCaching
public class Server 
{
    public static void main( String[] args ) throws Exception
    {   System.setProperty("spring.devtools.restart.enabled", "true");

    	SpringApplication.run(Server.class, args);
        
    }
    @Cacheable(value="cache1")
    @RequestMapping("/hello")
    public Map<String,String> hello() {
    	Map<String,String> m =new HashMap<String,String>();
    	m.put("sun", "hello sun");
		return m;
    	
    }
    @Cacheable(value="cache1")
    @RequestMapping("/hello1")
    public Map<String,String> hello2() {
    	Map<String,String> m =new HashMap<String,String>();
    	m.put("sun", "hello sun颠三倒四");
		return m;
    	
    }
    @Cacheable(value="cache2")
    @RequestMapping("/hello3")
    public Map<String,String> hello3() {
    	Map<String,String> m =new HashMap<String,String>();
    	m.put("sun", "helloworldddddd");
		return m;
    	
    }
    @Cacheable(value="cache4")
    @RequestMapping("/hello4")
    public Map<String,String> hello4() {
    	Map<String,String> m =new HashMap<String,String>();
    	m.put("sun", "hellossss");
		return m;
    	
    }
  /*  @Cacheable(value="cache1")
    @RequestMapping("/hello1")
    public String hello1() {
    	
		return "dsddd";
    	
    }*/
    
   
}
