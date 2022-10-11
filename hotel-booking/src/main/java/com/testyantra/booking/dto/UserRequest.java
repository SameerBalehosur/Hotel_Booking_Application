package com.testyantra.booking.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(value = Include.NON_DEFAULT)
@Builder(access = AccessLevel.PUBLIC)
@Component
public class UserRequest {
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