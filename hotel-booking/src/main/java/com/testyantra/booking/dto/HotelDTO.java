package com.testyantra.booking.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
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
public class HotelDTO {
	private String hotelId;
	private String hotelName;
	private String city;
	private String date;
	@JsonIgnore
	private String fid;
	private List<Facilities> facilities;
}
