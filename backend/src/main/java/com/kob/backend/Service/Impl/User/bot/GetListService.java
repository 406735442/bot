package com.kob.backend.Service.Impl.User.bot;

import com.kob.backend.Pojo.Bot;

import java.util.List;
import java.util.Map;

public interface GetListService {
    List<Bot> getBotList (Map<String,String> data);
}
