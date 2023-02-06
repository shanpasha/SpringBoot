package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

}
