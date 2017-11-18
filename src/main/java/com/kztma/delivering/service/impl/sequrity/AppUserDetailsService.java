package com.kztma.delivering.service.impl.sequrity;

import com.kztma.delivering.domain.User;
import com.kztma.delivering.pojo.RoleType;
import com.kztma.delivering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kztma.delivering.util.SecurityUtil.sha256Decode;

/**
 * Created by cccc on 11/18/2017.
 */

@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Value("${embedded.admin.login}")
    private String embeddedAdminLogin;

    @Value("${emmbedded.admin.password}")
    private String embeddedAdminPassword;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if (embeddedAdminLogin.equalsIgnoreCase(s)) {
            return buildAndGetEmbeddedAdmin();
        }

        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

    private UserDetails buildAndGetEmbeddedAdmin() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Arrays.stream(RoleType.values()).forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toString())));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(embeddedAdminLogin, sha256Decode(embeddedAdminPassword), authorities);

        return userDetails;
    }
}
