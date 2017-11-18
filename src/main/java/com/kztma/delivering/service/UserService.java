package com.kztma.delivering.service;

import com.kztma.delivering.domain.User;

import java.util.List;

/**
 * Created by cccc on 11/18/2017.
 */
public interface UserService {

    List<User> findAll();
    void create(User user);
    void update(User user);
    void delete(Long id);
    void register(User user);
}
