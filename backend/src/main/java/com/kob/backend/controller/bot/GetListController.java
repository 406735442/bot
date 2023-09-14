package com.kob.backend.controller.bot;

import com.kob.backend.Pojo.Bot;
import com.kob.backend.Service.Impl.User.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/user/bot/getlist/")
    public List<Bot> getList (Map<String,String> data){
        return getListService.getBotList(data);
    }
}
