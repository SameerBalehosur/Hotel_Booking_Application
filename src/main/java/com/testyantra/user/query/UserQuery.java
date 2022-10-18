package com.testyantra.user.query;

import org.springframework.stereotype.Component;

/**
 * @author Sameer Balehosur
 *
 */
@Component
public final class UserQuery {
	public static String GET_USER_DETAILS="SELECT * FROM USER_DETAILS WHERE USERID=:USERID";
	public static String ADD_USER_DETAILS="INSERT INTO USER_DETAILS(USERID,USERNAME,PHONENO,EMAILID,ADDRESS,HOTELID,RATINGS,COMMENTS,FID) "
			+ "VALUES(:USERID,:USERNAME,:PHONENO,:EMAILID,:ADDRESS,:HOTELID,:RATINGS,:COMMENTS,:FID)";
	public static String DELETE_USER_DETAILS="DELETE FROM USER_DETAILS WHERE USERID=:USERID";
	public static String USER_COMMENTS="INSERT INTO ";

}
