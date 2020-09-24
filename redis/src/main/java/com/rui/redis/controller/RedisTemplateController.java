package com.rui.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class RedisTemplateController {
    private final static String XIAO_BAI = "author";

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/expirationTime")
    public void redisExpirationTime() {
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

    public static void main(String[] args){
        String str = "[1711, 157, 1511, 179, 137, 357, 159, 1311, 3511, 379, 139, 359, 579, 5711, 3711, 5911, 3911, 1911]";
       String numX = "13,35,15", numD ="79,911,711";
      List numXlist = Arrays.asList(numX.split(","));
      List numDlist = Arrays.asList(numD.split(","));
      List d = Arrays.asList("7,9,11".split(","));
      List x = Arrays.asList("1,3,5".split(","));

      Set setX = new HashSet();
      d.forEach(m->{
          numXlist.forEach(n->{
              setX.add(""+n+m);
          });
      });

      x.forEach(m->{
          numDlist.forEach(n->{
              setX.add(""+m+n);
          });
      });

      Set allParam = new HashSet();
      List noParam = Arrays.asList("3".split(","));
     setX.forEach(m->{

             if(m.toString().indexOf("1")<0 && m.toString().indexOf("7")<0){

                 allParam.add(m);
             }

     });
     System.out.println(setX.size() +"setX: "+setX);
        System.out.println(allParam.size());
        System.out.print(allParam);


    }


}
