package com.testyantra.user.common;

import org.springframework.stereotype.Component;

@Component
public final class UserConstants {
	public static String SUCESS_STATUS_CODE="M200";
	public static String FAIL_STATUS_CODE="M400";
	public static String SUCESS_STATUS_DESC="SUCESS";
	public static String FAIL_STATUS_DESC="FAILED";
	public static String DATA_ADDED_MSG="User Data Added Successfully";
	public static String DATA_DELETED_MSG="User Data Deleted Successfully";
	public static String USER_REVIEW="User COMMENTS/REVIEW Added Successfully";
	
	
	public static String GET_USER_DETAILS="SELECT * FROM USER_DETAILS WHERE USERID=:USERID";
	public static String ADD_USER_DETAILS="INSERT INTO USER_DETAILS(USERID,USERNAME,PHONENO,EMAILID,ADDRESS,HOTELID,RATINGS,COMMENTS,FID) "
			+ "VALUES(:USERID,:USERNAME,:PHONENO,:EMAILID,:ADDRESS,:HOTELID,:RATINGS,:COMMENTS,:FID)";
	public static String DELETE_USER_DETAILS="DELETE FROM USER_DETAILS WHERE USERID=:USERID";
	public static String USER_COMMENTS="INSERT INTO ";
}
