package com.kob.backend.controller.Pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pk")
public class pk {
    @RequestMapping ("/getbot")
    public Map getbotinfo(){
        Map<String,String> map = new HashMap();
        map.put("bot_rating","1200");
        map.put("bot_name","bot");
        return map;
    }
    @RequestMapping("/index")
    public String index(){
        return "templates/index.html";
    }
}
