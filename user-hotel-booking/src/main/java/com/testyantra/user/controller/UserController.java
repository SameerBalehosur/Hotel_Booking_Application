package com.testyantra.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.user.request.UserRequest;
import com.testyantra.user.response.UserResponse;
import com.testyantra.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sameer Balehosur
 *
 */
@RestController
@RequestMapping(path = "/hotels/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	/** User Login API */
	@GetMapping("/login")
	public String getAllHotels() {
		log.info("Inside  the APIS");
		return "User Module is Working";
	}
	/**Getting User Details API */
	@PostMapping("/getUser")
	public UserResponse getAllUsers(@RequestBody UserRequest userRequest) {
		return userService.getUserDetails(userRequest);
	}
	/**Adding User Details API */
	@PostMapping("/addUserDetails")
	public UserResponse addUser(@RequestBody UserRequest userRequest) {
		return userService.addUser(userRequest);
	}
	/**Deleting User Details API */
	@PostMapping("/deleteUser")
	public UserResponse deletUser(@RequestBody UserRequest userRequest) {
		return userService.deleteUser(userRequest);
	}
	/**User To add review/Comment on Hotel API */
	@PostMapping("/feedback")
	public UserResponse addReview(@RequestBody UserRequest userRequest,@RequestHeader String hotelId) {
		userRequest.setHotelId(hotelId);
		return userService.addReview(userRequest);
	}

}
