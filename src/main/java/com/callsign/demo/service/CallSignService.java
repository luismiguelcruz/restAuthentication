package com.callsign.demo.service;

import com.callsign.demo.pojo.User;

public interface CallSignService {
    User getDefaultUser();

    User getUser(String id);
}
