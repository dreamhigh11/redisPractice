package com.sun.chat.controller;

import com.sun.chat.queue.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/index")
    public void index(){

        redisTemplate.convertAndSend("messageQueue","sun Handsome!");

        //return redisTemplate.opsForValue().get("user").toString();
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("message", RedisMessageSubscriber.messageList.get(0));


        return "main"; //view
    }
}
