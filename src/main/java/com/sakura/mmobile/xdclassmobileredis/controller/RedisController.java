package com.sakura.mmobile.xdclassmobileredis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/setAndGet")
    public String setAndGetValue(@RequestParam String name, @RequestParam String value) {
        redisTemplate.opsForValue().set(name, value);
        return (String)redisTemplate.opsForValue().get(name);
    }
}
