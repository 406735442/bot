package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/pk/")
public class pk {
    @RequestMapping("/index")
    public List<Map<String,String>> getInfo(){
        List<Map<String,String>> list = new LinkedList<>();
        Map<String,String> bot1 = new HashMap<>();
        bot1.put("name","tiger");
        bot1.put("rating","1500");
        Map<String,String> bot2 = new HashMap<>();
        bot2.put("name","triger");
        bot2.put("rating","1500");
        list.add(bot1);
        //list.add(bot2);
        return list;
    }
    @RequestMapping("/getinfo")
    public Map<String,String> GetInfomation(){
        Map<String,String> bot1 = new HashMap<>();
        bot1.put("name","tiger");
        bot1.put("rating","1500");
        return bot1;
    }
}
