package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Long> {

	@Query(nativeQuery = true,value="delete from user_role where user_id=?1")
	public void deleteUserRole(Long id);

}
