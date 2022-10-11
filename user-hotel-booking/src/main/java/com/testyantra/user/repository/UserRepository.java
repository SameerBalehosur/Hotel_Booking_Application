package com.testyantra.user.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.testyantra.user.common.UserConstants;
import com.testyantra.user.dto.UserDTO;
import com.testyantra.user.request.UserRequest;
import com.testyantra.user.response.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
@Component
public class UserRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	
	public UserResponse getUserDetails(UserRequest request) {
		String methodName = "getUserDetails";
		log.info("Inside the " + methodName);
		try {
			if (request != null) {

				MapSqlParameterSource params = new MapSqlParameterSource()
						.addValue("USERID", request.getUserId());
				List<UserDTO> query = jdbcTemplate.query(UserConstants.GET_USER_DETAILS, params, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
				if(!query.isEmpty()) {
					return UserResponse.builder().userDetails(query).build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while fetching the Data "+methodName);
		}
		return null;

	}
	
	public UserResponse addUserDetails(UserRequest request) {
		String methodName = "addUserDetails";
		log.info("Inside the " + methodName);
		try {
			if (request != null) {

				MapSqlParameterSource params = new MapSqlParameterSource()
						.addValue("USERID", request.getUserId())
								.addValue("USERNAME", request.getUserName())
								.addValue("PHONENO", request.getPhoneNo())
								.addValue("EMAILID", request.getEmailId())
								.addValue("ADDRESS", request.getAddress())
								.addValue("HOTELID", request.getHotelId())
								.addValue("RATINGS", request.getRatings())
								.addValue("COMMENTS", request.getComments())
								.addValue("FID", request.getFId());
				log.info("Parameters Values "+params.getValues());
				int update = jdbcTemplate.update(UserConstants.ADD_USER_DETAILS, params);
				if(update>0) {
					log.info(" User Data Added Done "+params );
					return UserResponse.builder().Message(UserConstants.DATA_ADDED_MSG).build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while Adding the Data "+methodName);
		}
		return null;

	}
	public UserResponse deleteUser(UserRequest request) {
			String methodName = "deleteUser";
			log.info("Inside the " + methodName);
			try {
				if (request != null) {

					MapSqlParameterSource params = new MapSqlParameterSource()
							.addValue("USERID", request.getUserId());
					log.info("Parameters Values "+params.getValues());
					int update = jdbcTemplate.update(UserConstants.DELETE_USER_DETAILS, params);
					if(update>0) {
						log.info(" User Data Deleted Done "+params );
						return UserResponse.builder().Message(UserConstants.DATA_DELETED_MSG).build();
					}
				}
			} catch (Exception e) {
				log.error("Exception Occured while Deleting the Data "+methodName);
			}
			return null;
		
	}
	
	public UserResponse addReview(UserRequest request) {
		String methodName = "deleteUser";
		log.info("Inside the " + methodName);
		try {
			if (request != null) {

				MapSqlParameterSource params = new MapSqlParameterSource()
						.addValue("USERID", request.getUserId())
						.addValue("USERNAME", request.getUserName())
						.addValue("RATINGS", request.getRatings())
						.addValue("COMMENTS", request.getComments());
				log.info("Parameters Values "+params.getValues());
				int update = jdbcTemplate.update(UserConstants.USER_COMMENTS, params);
				if(update>0) {
					log.info(" User Comments/Review Added to hotel "+params );
					return UserResponse.builder().Message(UserConstants.USER_REVIEW).build();
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured while Adding Comments/Review To Hotel "+methodName);
		}
		return null;
	
}
}
