package com.kob.backend.controller.user.account;

import com.kob.backend.Service.Impl.User.account.photoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PhotoController {
    @Autowired
    private photoService photoService;

    @PostMapping("/user/account/photo")
    public String changePhoto(@RequestParam Map<String, String> data){
        return photoService.changePhoto(data);
    }
}
