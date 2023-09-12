package com.kob.backend.controller.Pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/123")
    public String index(){
        return "123";
    }
}
