package com.kztma.delivering.repository;

import com.kztma.delivering.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cccc on 11/18/2017.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
