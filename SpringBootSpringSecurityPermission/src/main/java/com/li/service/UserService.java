package com.li.service;

import com.li.model.User;

import java.util.Map;

public interface UserService {
	
	int save(User user);
	
	User findById(Long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findByConfirmationToken(String confirmationToken);
	
	User findAuthenticatedUser();
	
	Map<String, Object> getUserProfileAndPostsByUserIdByTabType(Long userId, String tabType);
	

	
	Map<String, Object> getUserSettingPage();


}
