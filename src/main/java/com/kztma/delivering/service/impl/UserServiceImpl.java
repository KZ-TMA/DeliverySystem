package com.kztma.delivering.service.impl;

import com.kztma.delivering.domain.User;
import com.kztma.delivering.repository.UserRepository;
import com.kztma.delivering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cccc on 11/18/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void register(User user) {

    }
}
