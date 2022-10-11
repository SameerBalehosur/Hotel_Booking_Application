package com.testyantra.booking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.booking.common.HotelConstants;
import com.testyantra.booking.dto.HotelDTO;
import com.testyantra.booking.dto.UserRequest;
import com.testyantra.booking.repository.HotelRepo;
import com.testyantra.booking.request.HotelRequest;
import com.testyantra.booking.response.HotelResponse;
import com.testyantra.booking.service.HotelService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sameer Balehosur
 *
 */
@Service
@Slf4j
@SuppressWarnings("unchecked")
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepo hotelRepo;

	@Override
	public HotelResponse addHotel(HotelRequest hotelRequest) {
		String methodName = "addHotel";
		log.info("Inside the" + methodName);
		try {
			if (hotelRequest != null) {
				int addHotel = hotelRepo.addHotel(hotelRequest);
				if (addHotel > 0) {
					log.info(methodName + " Added Hotel Data Success" + addHotel);
					return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
							.statusDescription("Successfully Added Hotel Data").build();
				}
			}
		} catch (Exception e) {
			log.error("Exception occured while Adding Data");
		}
		return HotelResponse.builder().statusCode(HotelConstants.FAIL_STATUS_CODE)
				.statusDescription(HotelConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public HotelResponse updateHotelInfo(HotelRequest hotelRequest) {
		String methodName = "updateHotelInformation";
		log.info(methodName + " Inside the");
		try {
			if (hotelRequest != null) {
				int updateHotelInfo = hotelRepo.updateHotelInfo(hotelRequest);
				if (updateHotelInfo > 0) {
					List<HotelRequest> hotelRequests = new ArrayList<>();
					hotelRequests.add(hotelRequest);
					return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
							.statusDescription(HotelConstants.SUCESS_STATUS_DESC).updatedHotelInfo(hotelRequests)
							.build();
				}
			}

		} catch (Exception e) {
			log.error("Exception occured while Updating Data");
		}
		return HotelResponse.builder().statusCode(HotelConstants.FAIL_STATUS_CODE)
				.statusDescription(HotelConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public HotelResponse getall() {
		String methodName = "addHotel";
		log.info(methodName + " Inside the");
		try {
			List<HotelDTO> getall = hotelRepo.getall();
			if (!getall.isEmpty()) {
				log.info("Fetched All Hotels Details " + getall);
				return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
						.statusDescription(HotelConstants.SUCESS_STATUS_DESC).listOfHotels(getall).build();
			}
		} catch (Exception e) {
			log.error("Exception occured while Fetching Data");
		}

		return HotelResponse.builder().statusCode(HotelConstants.FAIL_STATUS_CODE)
				.statusDescription(HotelConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public HotelResponse searchHotel(HotelRequest hotelRequest) {
		String methodName = "searchHotel";
		log.info("Inside the " + methodName);
		try {

			if (hotelRequest.getDate() != null) {
				HotelResponse searchHotel = hotelRepo.searchHotel(hotelRequest);
				List<HotelDTO> listOfHotels = searchHotel.getListOfHotels();
				if (!listOfHotels.isEmpty()) {

					return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
							.statusDescription(HotelConstants.SUCESS_STATUS_DESC).listOfHotels(listOfHotels).build();
				}
			} else if (hotelRequest.getCity() != null) {
				HotelResponse searchHotel = hotelRepo.searchHotel(hotelRequest);
				List<HotelDTO> listOfHotels = searchHotel.getListOfHotels();
				if (!listOfHotels.isEmpty()) {

					return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
							.statusDescription(HotelConstants.SUCESS_STATUS_DESC).listOfHotels(listOfHotels).build();
				}
			}
		} catch (Exception e) {
			log.error("Exception occured while Fetching Data");
		}
		return HotelResponse.builder().statusCode(HotelConstants.FAIL_STATUS_CODE)
				.statusDescription(HotelConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public HotelResponse deleteHotel(HotelRequest hotelRequest) {
		String methodName = "deleteHotel";
		log.info("Inside the " + methodName);
		try {

			if (hotelRequest != null) {
				int deleteHotelInfo = hotelRepo.deleteHotelInfo(hotelRequest);
				if (deleteHotelInfo > 0) {
					log.info("Hotel Information deleted Successfully " + deleteHotelInfo);
					return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
							.statusDescription(HotelConstants.SUCESS_STATUS_DESC).deletedData("Hotel Data Deleted")
							.build();
				}
			}

		} catch (Exception e) {
			log.error("Exception occured while Deleting Data");
		}
		return HotelResponse.builder().statusCode(HotelConstants.FAIL_STATUS_CODE)
				.statusDescription(HotelConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public HotelResponse addReview(UserRequest userRequest) {
		System.out.println(userRequest);
		 hotelRepo.updateHotel(userRequest);
		return HotelResponse.builder().statusCode(HotelConstants.SUCESS_STATUS_CODE)
				.statusDescription(HotelConstants.SUCESS_STATUS_DESC).feedback("Hotel feedback")
				.build();
	}

}
