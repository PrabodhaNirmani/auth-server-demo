package com.prabodha.oauth.authserverdemo.service;

import com.prabodha.oauth.authserverdemo.model.AuthUserDetail;
import com.prabodha.oauth.authserverdemo.model.User;
import com.prabodha.oauth.authserverdemo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    UserDetailsRepository userDetailsRepository;
//    load use details from the database and handover this to user detail service in the auth server config
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //get the user from the user name
        Optional<User> optionalUser = userDetailsRepository.findByUsername(name);
        //if the user name not exist throw the exception
        optionalUser.orElseThrow(()->new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());

        //check the user status of the get user
        new AccountStatusUserDetailsChecker().check(userDetails);


        return userDetails;



    }
}
