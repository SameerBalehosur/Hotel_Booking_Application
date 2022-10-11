package com.testyantra.booking.service;

import com.testyantra.booking.dto.UserRequest;
import com.testyantra.booking.request.HotelRequest;
import com.testyantra.booking.response.HotelResponse;
/**
 * @author Sameer Balehosur
 *
 */
public interface HotelService {
public HotelResponse addHotel(HotelRequest hotelRequest);
public HotelResponse updateHotelInfo(HotelRequest hotelRequest);
public HotelResponse getall();
public HotelResponse searchHotel(HotelRequest hotelRequest);
public HotelResponse deleteHotel(HotelRequest hotelRequest);
public HotelResponse addReview(UserRequest userRequest);
}
