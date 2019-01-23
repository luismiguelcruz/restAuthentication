package com.callsign.demo.service;

import com.callsign.demo.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CallSignServiceImpl implements CallSignService {
    private static final String DEFAULT_USER_NAME = "defaultUser";
    private static final String DEFAULT_USER_PASSWORD = "defaultPassword";


    @Override
    public User getDefaultUser() {
        return new User(DEFAULT_USER_NAME, DEFAULT_USER_PASSWORD);
    }

    @Override
    public User getUser(String id) {
        return new User(id, StringUtils.EMPTY);
    }
}
