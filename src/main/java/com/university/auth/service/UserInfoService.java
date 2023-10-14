package com.university.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.university.auth.model.User;
import com.university.auth.repository.UserInfoRepository;
 
@Service
public class UserInfoService implements UserDetailsService {
 
    @Autowired
    private UserInfoRepository repository;
 
    @Autowired
    private PasswordEncoder encoder;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userDetail = repository.findByUserName(userName);
        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + userName));
    }
    
    public User addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return userInfo;
    }
 
    public String getRole(String userName) {
    	Optional<User> userDetail = repository.findByUserName(userName);
    	return userDetail.get().getRoles();
    }
 
}