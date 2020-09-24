package com.rui.redis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestMain {
    private final static String XIAO_BAI = "author";

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testMethod(){
        System.out.println("ewqeqeqweq");
        Map<String, Object> map = new HashMap<String, Object>(16);
        List signList =null;
        if(!ObjectUtils.isEmpty(redisTemplate.opsForValue().get("usuallySign"))) {
            signList = (List) Objects.requireNonNull(redisTemplate.opsForValue().get("usuallySign"));
        }
        map.put("sdds2222",signList);

        List<Integer> list =new ArrayList();
        for(int i =0;i<100;i++){
            list.add(i);
        }
        map.put("vin",list);


        redisTemplate.opsForValue().set(XIAO_BAI, map);
        redisTemplate.expire(XIAO_BAI, 2, TimeUnit.SECONDS);

        while (true) {
            Object redisValue = redisTemplate.opsForValue().get(XIAO_BAI);
            if (ObjectUtils.isEmpty(redisValue)) {
                break;
            }
            System.out.println(redisValue);
        }
    }

    public static void main(String[] args) throws Exception{

        Map<String,Object> map = new  HashMap<String,Object>();
        map.put("sss","ssss");
        map.put("ccc","cccc");
        map.put("ddd","dddd");

        System.out.println(Arrays.asList(map.keySet()));
        List<String> list = new ArrayList(map.keySet());
        System.out.println(list);
    }
}
