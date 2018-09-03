package com.dzqd.comondao.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 15:49 2018/8/31
 * @Modified by:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/set/{key}/{values}/{time}")
    public void set(@PathVariable("key")String key,@PathVariable("values") String values,@PathVariable("time")Long time){

        stringRedisTemplate.opsForValue().set(key,values,time, TimeUnit.SECONDS);
    }

    @RequestMapping("/get/{key}")
    public String set(@PathVariable("key")String key){

        return  stringRedisTemplate.opsForValue().get(key);
    }
}
