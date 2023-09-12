package com.kob.backend.controller.user;

import com.kob.backend.Mapper.UserMapper;
import com.kob.backend.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/all")
    public List<User> getall(){
        return userMapper.selectList(null);
    }
    @GetMapping("/id/{userId}")
    public User getByid(@PathVariable int userId){
        return userMapper.selectById(userId);
    }
//    @GetMapping("/add/{userId}/{username}/{password}")
//    public String addUser(
//            @PathVariable int userId,
//            @PathVariable String username,
//            @PathVariable String password
//    ){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String EncodePassword = passwordEncoder.encode(password);
//        User user = new User(userId,username,EncodePassword);
//        userMapper.insert(user);
//        return "Add successfully";
//    }
}

