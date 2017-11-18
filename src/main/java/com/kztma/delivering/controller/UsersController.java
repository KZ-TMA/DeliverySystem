package com.kztma.delivering.controller;

import com.kztma.delivering.domain.User;
import com.kztma.delivering.pojo.RoleType;
import com.kztma.delivering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cccc on 11/18/2017.
 */

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    /*@RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<User> getUsers(){
        return userService.findAll();
    }*/

    @RequestMapping(value="roles", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('DISPATCHER')")
    public List<RoleType> getRoles(){
        return Arrays.stream(RoleType.values()).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUsers(){
        return userService.findAll();
    }
}
