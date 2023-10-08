package com.sun.chat.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        //RedisProperties.Lettuce lettuce = new Lettuce("127.0.0.1",8088);
        //System.out.println(jedis.ping());
    }
}
