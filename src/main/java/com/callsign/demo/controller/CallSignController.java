package com.callsign.demo.controller;

import com.callsign.demo.pojo.User;
import com.callsign.demo.service.CallSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallSignController {
    @Autowired
    private CallSignService callSignService;

    @GetMapping(value="/login")
    public User getAuthenticatedUser(Authentication authentication) {
        return callSignService.getUser(authentication.getName());
    }

    @GetMapping(path = "/user")
    public User retrieveDefaultUser(){
        User user = callSignService.getDefaultUser();

        return user;
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable String id){
        User user = callSignService.getUser(id);
        /*if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }*/

        return user;
    }
}
