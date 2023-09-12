package com.kob.backend.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.Mapper.UserMapper;
import com.kob.backend.Pojo.User;
import com.kob.backend.Service.Impl.User.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String,String> map = new HashMap<>();
        if(username == null){
            map.put("error_message","用户名不能为空");
            return map;
        }
        username = username.trim();//删除前面的空白字符
        if(password == null || confirmedPassword == null){
            map.put("error_message","密码或确认密码不能为空");
            return map;
        }
        if(!password.equals(confirmedPassword)){
            map.put("error_message","密码与确认密码不一致");
            return map;
        }
        if (username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }
        if(password.length() == 0 || confirmedPassword.length() == 0){
            map.put("error_message", "密码和确认密码不能为空");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码不能大于100");
            return map;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username",username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()){
            map.put("error_message","用户名已存在");
            return map;
        }
        String encodePassword = passwordEncoder.encode(password);
        String photo = "!@#";
        User user = new User(null,username,encodePassword,photo);
        map.put("error_message","success");
        userMapper.insert(user);
        return map;
    }
}
