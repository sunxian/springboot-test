/*package com.sun.springbootTest.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

import com.sun.springbootTest.entity.User;
@Component
public class HashMapping {
	
	
	  @Autowired
	  HashOperations<String, byte[], byte[]> hashOperations;

	  HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

	  public void writeHash(String key, User user) {

	    Map<byte[], byte[]> mappedHash = mapper.toHash(user);
	    hashOperations.putAll(key, mappedHash);
	  }

	  public User loadHash(String key) {

	    Map<byte[], byte[]> loadedHash = hashOperations.entries("key");
	    return (User) mapper.fromHash(loadedHash);
	  }


}
*/