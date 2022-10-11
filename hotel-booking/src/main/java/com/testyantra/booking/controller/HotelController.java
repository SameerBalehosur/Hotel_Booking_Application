package com.testyantra.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.booking.dto.UserRequest;
import com.testyantra.booking.request.HotelRequest;
import com.testyantra.booking.response.HotelResponse;
import com.testyantra.booking.service.HotelService;

/**
 * @author Sameer Balehosur
 *
 */
@RestController
@RequestMapping(path = "/hotels")
public class HotelController {
	
	@Autowired
	HotelService hotelInterface;
	
	/** Getting All Hotel Information API */
	@PostMapping("/feedback")
	public HotelResponse userFeedbackHotel(@RequestBody UserRequest userRequest) {
		return hotelInterface.addReview(userRequest);
	}
	
	/** Getting All Hotel Information API */
	@GetMapping("/getAllHotels")
	public HotelResponse getAllHotels() {
		return hotelInterface.getall();
	
	}
	
	/** Adding Hotel Information API */
	@PostMapping("/addHotelInfo")
	public HotelResponse addHotelInfo( @RequestBody HotelRequest hotelRequest) {
		return hotelInterface.addHotel(hotelRequest);
	}
	
	/** Updating Hotel Information API */
	@PostMapping("/updateHotelInfo")
	public HotelResponse updateHotelInfo(@Validated @RequestBody HotelRequest hotelRequest) {
		return hotelInterface.updateHotelInfo(hotelRequest);
	}
	
	/** Searching Hotel By Date & City API */
	@PostMapping("/searchHotel")
	public HotelResponse searchHotelByDate(@Validated @RequestBody HotelRequest hotelRequest) {
		return hotelInterface.searchHotel(hotelRequest);
	}
	
	/** Deleting Hotel Information API */
	@PostMapping("/deleteHotelInfo")
	public HotelResponse deleteHotel(@Validated @RequestBody HotelRequest hotelRequest) {
		return hotelInterface.deleteHotel(hotelRequest);
	}
}
