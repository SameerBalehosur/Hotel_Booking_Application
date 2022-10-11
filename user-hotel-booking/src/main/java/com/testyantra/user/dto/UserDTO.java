package com.testyantra.user.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sameer Balehosur
 *
 */
@Component
@Getter
@Setter
@ToString
public class UserDTO {
	private String userId;
	private String userName;
	private String phoneNo;
	private String emailId;
	private String address;
	private String hotelId;
	private String ratings;
	private String comments;
	private String fId;

}
