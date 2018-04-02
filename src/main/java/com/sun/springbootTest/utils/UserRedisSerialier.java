package com.sun.springbootTest.utils;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.lang.Nullable;

import com.sun.springbootTest.entity.User;

public class UserRedisSerialier extends JdkSerializationRedisSerializer{

	public User deserialize(@Nullable byte[] bytes) {

		if (SerializationUtils.isEmpty(bytes)) {
			return null;
		}

		try {
			return super.deserializer.convert(bytes);
		} catch (Exception ex) {
			throw new SerializationException("Cannot deserialize", ex);
		}
	}

	public byte[] serialize(User user) {
		// TODO Auto-generated method stub
		return super.serialize(user);
	}


	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
