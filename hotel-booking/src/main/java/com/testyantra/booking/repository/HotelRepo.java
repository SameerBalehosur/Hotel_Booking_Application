package com.testyantra.booking.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testyantra.booking.dto.Facilities;
import com.testyantra.booking.dto.HotelDTO;
import com.testyantra.booking.dto.UserRequest;
import com.testyantra.booking.query.HotelQuery;
import com.testyantra.booking.request.HotelRequest;
import com.testyantra.booking.response.HotelResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sameer Balehosur
 *
 */
@Slf4j
@Repository
@SuppressWarnings("unchecked")
public class HotelRepo {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	HotelQuery hoteQuery;

	public int addHotel(HotelRequest request) {
		String methodName = "addHotel";
		String addQuery = hoteQuery.ADD_HOTEL_INFORMATION;
		try {
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
					.addValue("CITY", request.getCity()).addValue("HOTELID", request.getHotelId())
					.addValue("HOTELNAME", request.getHotelName()).addValue("DATE", request.getDate())
					.addValue("FID", request.getFId());
			log.info("Fetched vales" + mapSqlParameterSource.getValues());
			int update2 = jdbcTemplate.update(addQuery, mapSqlParameterSource);

			if (update2 > 0) {
				log.info(methodName + "Data Insertion done");
				System.err.println("Insertion confirmation");
				return update2;
			}

		} catch (Exception e) {
			log.error("Exception Occured while performoing operation");
		}
		return 0;

	}

	public List<HotelDTO> getall() {
		String get_all = hoteQuery.GET_ALL;
		String get_all_facility = hoteQuery.GET_ALL_FACILITY;
		List<HotelDTO> query = jdbcTemplate.query(get_all, new BeanPropertyRowMapper(HotelDTO.class));
		List<Facilities> query2 = jdbcTemplate.query(get_all_facility, new BeanPropertyRowMapper(Facilities.class));
		List<HotelDTO> collect = query.stream().map(hotalDto -> {
			hotalDto.setFacilities(
					query2.stream().filter(fac -> fac.getFId().equals(hotalDto.getFid())).collect(Collectors.toList()));
			return hotalDto;
		}).collect(Collectors.toList());

		if (!collect.isEmpty()) {
			return collect;
		}
		return null;
	}

	public int updateHotelInfo(HotelRequest request) {
		String methodName = "addHotel";
		String updateQuery = hoteQuery.UPDATE_HOTEL_INFO;
		try {
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
					.addValue("HOTELID", request.getHotelId()).addValue("HOTELNAME", request.getHotelName());
			log.info("Fetched vales" + mapSqlParameterSource.getValues());
			int update = jdbcTemplate.update(updateQuery, mapSqlParameterSource);

			if (update > 0) {
				log.info(methodName + "Hotel Information Updated Successfully ");
				return update;
			}

		} catch (Exception e) {
			log.error("Exception Occured while performoing operation");
		}
		return 0;

	}

	public int updateHotel(UserRequest request) {
		String methodName = "updateHotel";
		String updateQuery = hoteQuery.UPDATE_HOTEL_FEEDBACK;
		try {
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
					.addValue("HOTELID", request.getHotelId()).addValue("USERCOMMENTS", request.getComments())
					.addValue("USERREVIEW", request.getRatings());
			log.info("Fetched vales" + mapSqlParameterSource.getValues());
			int update = jdbcTemplate.update(updateQuery, mapSqlParameterSource);

			if (update > 0) {
				log.info(methodName + "Hotel Information Updated Successfully ");
				return update;
			}

		} catch (Exception e) {
			log.error("Exception Occured while performoing operation");
		}
		return 0;

	}

	public HotelResponse searchHotel(HotelRequest hotelRequest) {
		String methodname = "searchHotel";
		try {
			if (hotelRequest.getCity() != null) {

				MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("CITY",
						hotelRequest.getCity());
				List<HotelDTO> query = jdbcTemplate.query(hoteQuery.FIND_HOTELS_BY_CITY, mapSqlParameterSource,
						new BeanPropertyRowMapper(HotelDTO.class));
//				List<Facilities> facilities = jdbcTemplate.query(hoteQuery.FIND_HOTELS_BY_CITY, mapSqlParameterSource,
//						new BeanPropertyRowMapper(HotelDTO.class));
				log.info("Fetched vales" + mapSqlParameterSource.getValues());
//				query.stream().filter(a->a)
				if (query != null) {
					return HotelResponse.builder().listOfHotels(query).build();
				}
			} else if (hotelRequest.getDate() != null) {
				MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("DATE",
						hotelRequest.getDate());
				List query = jdbcTemplate.query(hoteQuery.FIND_HOTELS_BY_DATE, mapSqlParameterSource,
						new BeanPropertyRowMapper(HotelDTO.class));
				log.info("Fetched vales" + mapSqlParameterSource.getValues());
				if (query != null) {
					return HotelResponse.builder().listOfHotels(query).build();
				}
			}
		} catch (Exception e) {
			log.error("Error Occured while performing an operaion" + methodname);
		}
		return null;
	}

	public int deleteHotelInfo(HotelRequest request) {
		String methodName = "addHotel";
		String updateQuery = hoteQuery.DELETE_HOTEL_INFO;
		try {
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
					.addValue("HOTELID", request.getHotelId()).addValue("HOTELID", request.getHotelId());
			log.info("Fetched vales" + mapSqlParameterSource.getValues());
			int update = jdbcTemplate.update(updateQuery, mapSqlParameterSource);

			if (update > 0) {
				log.info(methodName + "Hotel Information Updated Successfully ");
				return update;
			}

		} catch (Exception e) {
			log.error("Exception Occured while performoing operation");
		}
		return 0;

	}
}
