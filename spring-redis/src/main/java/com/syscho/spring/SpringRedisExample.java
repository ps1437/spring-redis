package com.syscho.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.syscho.spring.config.RedisConfig;
import com.syscho.spring.vo.Person;

/**
 * @author Praveen $oni
 *
 */
public class SpringRedisExample {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
		try {

			RedisTemplate<String, Object> redisTemplate = ctx.getBean(RedisTemplate.class);

			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			values.set("key", new Person("kumar", 24));

			System.out.println("Person : " + values.get("key"));
		} finally {
			ctx.close();
		}
	}
}