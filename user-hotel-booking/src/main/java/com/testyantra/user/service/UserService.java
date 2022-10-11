package com.testyantra.user.service;

import org.springframework.stereotype.Component;

import com.testyantra.user.request.UserRequest;
import com.testyantra.user.response.UserResponse;
public interface UserService {
	
	public UserResponse getUserDetails(UserRequest userRequest);
	public UserResponse addUser(UserRequest userRequest);
	public UserResponse deleteUser(UserRequest userRequest);
	public UserResponse addReview(UserRequest userRequest);

}
