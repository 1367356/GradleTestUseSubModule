package com.li.service;

import com.qingwenwei.event.OnRegistrationCompleteEvent;
import com.qingwenwei.persistence.dao.CommentMapper;
import com.qingwenwei.persistence.dao.PostMapper;
import com.qingwenwei.persistence.dao.UserMapper;
import com.qingwenwei.persistence.model.Comment;
import com.qingwenwei.persistence.model.Post;
import com.qingwenwei.persistence.model.User;
import com.qingwenwei.service.StorageService;
import com.qingwenwei.service.UserService;
import com.qingwenwei.web.dto.UserRegistrationDto;
import com.qingwenwei.web.dto.UserSettingsDto;
import org.apache.log4j.LogManager;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Service("userService")
public class UserServiceImpl  {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
//	@Autowired
//	private VerificationTokenMapper verificationTokenMapper;
	
	@Autowired
	private StorageService storageService;

	
	@Autowired
	private ApplicationEventPublisher evenPublisher;
	



	/**
	 * 更新用户profile
	 * @param userSettingsDto
	 * @return
	 */
	@Override
	public Map<String, Object> updateUserProfile(UserSettingsDto userSettingsDto) {
		Map<String, Object> attributes = new HashMap<>();
//		String authenticatedUsername = this.findAuthenticatedUser().getUsername();
		User authenticatedUser = this.findAuthenticatedUser();

		String authenticatedUsername = authenticatedUser.getUsername();
		String password = authenticatedUser.getPassword();
		if (null == authenticatedUsername || authenticatedUsername.equalsIgnoreCase("")
				|| null == userSettingsDto
				|| userSettingsDto.getEmail().isEmpty()
				|| userSettingsDto.getEmail().equals("")) {
			attributes.put("uploadResultMessage", "uploadFailure");
			return attributes;
		}
		// update user profile
		User user = this.storageService.store(userSettingsDto.getAvatar(), authenticatedUsername);  //存储图片
		if (null == user) {
			attributes.put("uploadResultMessage", "uploadFailure");
			user = this.findAuthenticatedUser(); // find authenticated user if no user found
		}
		user.setPassword(password);
		user.setEmail(userSettingsDto.getEmail());
		user.setBio(userSettingsDto.getBio());

		this.userMapper.update(user);   //更新该连接
		
		// return attributes
		attributes.put("user", user);
		attributes.put("uploadResultMessage", "uploadSuccess");
		return attributes;
	}


}
