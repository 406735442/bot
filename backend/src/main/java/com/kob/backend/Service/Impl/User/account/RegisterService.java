package com.kob.backend.Service.Impl.User.account;

import java.util.Map;

public interface RegisterService {
    public Map<String,String> register(String username, String password, String ConfirmedPassword);
}
