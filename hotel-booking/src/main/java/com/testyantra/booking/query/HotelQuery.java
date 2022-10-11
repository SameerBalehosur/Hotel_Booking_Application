package com.testyantra.booking.query;

import org.springframework.stereotype.Component;
/**
 * @author Sameer Balehosur
 *
 */
@Component
public class HotelQuery {
	
	public static final String GET_ALL_FACILITY = "SELECT * FROM facilities ";
	public String ADD_HOTEL_INFORMATION = "INSERT INTO HOTEL(HOTELID,HOTELNAME,CITY,DATE,FID) VALUES(:HOTELID,:HOTELNAME,:CITY,:DATE,:FID)";
//	public String GET_ALL = "select a.*,b.* from hotel a inner join facilities b on a.fid=b.fid";
	public String GET_ALL = "select * from hotel";
	public String UPDATE_HOTEL_INFO = "UPDATE HOTEL SET HOTELNAME=:HOTELNAME WHERE HOTELID=:HOTELID";
	public String UPDATE_HOTEL_FEEDBACK = "UPDATE HOTEL SET USERCOMMENTS=:USERCOMMENTS , USERREVIEW=:USERREVIEW WHERE HOTELID=:HOTELID";
	public String FIND_HOTELS_BY_CITY = "SELECT * FROM hotel WHERE CITY=:CITY";
	public String FIND_HOTELS_BY_DATE = "SELECT * FROM hotel WHERE DATE=:DATE";
	public String DELETE_HOTEL_INFO = "delete from hotel where HOTELID=:HOTELID";
	
	
}
