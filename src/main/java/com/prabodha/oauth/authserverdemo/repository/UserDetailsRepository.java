package com.prabodha.oauth.authserverdemo.repository;

import com.prabodha.oauth.authserverdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository  extends JpaRepository<User,Integer > {

    Optional<User> findByUsername(String username);

}
