package com.example.securitydemo.repository;

import com.example.securitydemo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findUserByUsername(String username);

}
