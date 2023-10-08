package com.sun.chat;


import com.sun.chat.Model.User;
import com.sun.chat.queue.RedisMessagePublisher;
import com.sun.chat.queue.RedisMessageSubscriber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class ChatApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private RedisMessagePublisher redisMessagePublisher;
	@Test
	void contextLoads() {
		User user = new User(1,"sun",true);

		redisTemplate.opsForValue().set("user",user);
		User user1 = (User) redisTemplate.opsForValue().get("user");
		System.out.println("####"+user1.getUsername());
	}

	@Test
	public void testOnMessage() throws Exception {
		String message = "Message " + UUID.randomUUID();
		redisMessagePublisher.publish(message);
		Thread.sleep(1000);
		assertTrue(RedisMessageSubscriber.messageList.get(0).contains(message));
	}






}
