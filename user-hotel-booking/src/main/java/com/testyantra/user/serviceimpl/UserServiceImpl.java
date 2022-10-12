package com.testyantra.user.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.testyantra.user.common.UserConstants;
import com.testyantra.user.dto.UserDTO;
import com.testyantra.user.repository.UserRepository;
import com.testyantra.user.request.UserRequest;
import com.testyantra.user.response.HotelResponse;
import com.testyantra.user.response.UserResponse;
import com.testyantra.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserResponse getUserDetails(UserRequest userRequest) {
		String methodName = "getUserDetails";
		log.info("Inside the " + methodName);
		try {
			if (userRequest != null) {
				UserResponse userDetails = userRepository.getUserDetails(userRequest);
				if (userDetails != null) {
					List<UserDTO> listOfUsers = userDetails.getUserDetails();
					log.info("Fetched The user Deatils" + listOfUsers);
					return UserResponse.builder().statusCode(UserConstants.SUCESS_STATUS_CODE)
							.statusDescription(UserConstants.SUCESS_STATUS_DESC).userDetails(listOfUsers).build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while fetching the Data " + methodName);
		}
		return UserResponse.builder().statusCode(UserConstants.FAIL_STATUS_CODE)
				.statusDescription(UserConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public UserResponse addUser(UserRequest userRequest) {
		String methodName = "getUserDetails";
		log.info("Inside the " + methodName);
		try {
			if (userRequest != null) {
				UserResponse userDetails = userRepository.addUserDetails(userRequest);
				String message = userDetails.getMessage();
				if (message.equalsIgnoreCase(UserConstants.DATA_ADDED_MSG)) {
					log.info("Added user Deatils" + message);
					return UserResponse.builder().statusCode(UserConstants.SUCESS_STATUS_CODE)
							.statusDescription(UserConstants.SUCESS_STATUS_DESC).Message(UserConstants.DATA_ADDED_MSG)
							.build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while fetching the Data " + methodName);
		}
		return UserResponse.builder().statusCode(UserConstants.FAIL_STATUS_CODE)
				.statusDescription(UserConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public UserResponse deleteUser(UserRequest userRequest) {
		String methodName = "getUserDetails";
		log.info("Inside the " + methodName);
		try {
			if (userRequest != null) {
				UserResponse userDetails = userRepository.deleteUser(userRequest);
				String message = userDetails.getMessage();
				if (message.equalsIgnoreCase(UserConstants.DATA_DELETED_MSG)) {
					log.info("Added user Deatils" + message);
					return UserResponse.builder().statusCode(UserConstants.SUCESS_STATUS_CODE)
							.statusDescription(UserConstants.SUCESS_STATUS_DESC).Message(UserConstants.DATA_DELETED_MSG)
							.build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while fetching the Data " + methodName);
		}
		return UserResponse.builder().statusCode(UserConstants.FAIL_STATUS_CODE)
				.statusDescription(UserConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public UserResponse addReview(UserRequest userRequest) {
		String methodName = "addReview";
		log.info("Inside the " + methodName);
		try {
			if (userRequest != null) {
				String url="http://localhost:8080/hotels/feedback";
				ResponseEntity<HotelResponse> addReview = restTemplate.postForEntity(url, userRequest, HotelResponse.class);
//				System.out.println(addReview.getStatusCodeValue());
				if (addReview.getStatusCodeValue()==200) {
//					log.info("Added user Deatils" + message);
					return UserResponse.builder().statusCode(UserConstants.SUCESS_STATUS_CODE)
							.statusDescription(UserConstants.SUCESS_STATUS_DESC).Message(UserConstants.USER_REVIEW)
							.build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while Adding the Review/Comments " + methodName);
		}
		return UserResponse.builder().statusCode(UserConstants.FAIL_STATUS_CODE)
				.statusDescription(UserConstants.FAIL_STATUS_DESC).build();
	}

}
