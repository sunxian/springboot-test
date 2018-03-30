package com.sun.springbootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * start class
 *
 */
@SpringBootApplication
@RestController
public class Server 
{
    public static void main( String[] args ) throws Exception
    {   System.setProperty("spring.devtools.restart.enabled", "true");

    	SpringApplication.run(Server.class, args);
        
    }
    @RequestMapping("/hello")
    public String hello() {
		return "hello sun";
    	
    }
}
