package com.kob.backend.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.Mapper.UserMapper;
import com.kob.backend.Pojo.User;
import com.kob.backend.Service.Impl.User.account.photoService;
import com.kob.backend.Service.Impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class photoServiceImpl implements photoService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String changePhoto(Map<String, String> data) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) usernamePasswordAuthenticationToken.getPrincipal();
        User user = loginUser.getUser();
        int id = user.getId();
        user.setPhoto(data.get("photo"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("id",id);
        userMapper.update(user,queryWrapper);
        return "修改头像成功";
    }
}
