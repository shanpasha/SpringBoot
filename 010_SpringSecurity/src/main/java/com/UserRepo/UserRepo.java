package com.UserRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Long> {
	
	@Query(nativeQuery = true ,value ="select*from user_info u where u.user_name=?1")
	public UserInfo findByUserName(String userName);

}
