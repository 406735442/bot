package com.kob.backend.Service.Impl;

import com.kob.backend.Mapper.BotMapper;
import com.kob.backend.Pojo.Bot;
import com.kob.backend.Pojo.User;
import com.kob.backend.Service.Impl.User.bot.RemoveBot;
import com.kob.backend.Service.Impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveBotImpl implements RemoveBot {

    @Autowired
    private BotMapper botMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails loginuser = (UserDetailsImpl) usernamePasswordAuthenticationToken.getPrincipal();
        User user = new User();
        int bot_id = Integer.parseInt(data.get("bot_id"));
        Bot bot = botMapper.selectById(bot_id);
        Map<String,String> map = new HashMap<>();

        if(bot == null){
            map.put("error_message","bot不存在或者已被删除");
            return map;
        }
        if(!bot.getUserId().equals(user.getId())){
            map.put("error_message","没有权限删除bot");
            return map;
        }
        botMapper.deleteById(bot_id);
        map.put("error_message","删除成功");
        return map;
    }
}
