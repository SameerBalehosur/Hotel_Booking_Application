package com.testyantra.booking.dto;

import java.util.List;

import org.springframework.stereotype.Component;

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
public class Facilities {
	private String fId;
	private String ac;
	private String tv;
	private String food;
	private String telehone;
	private String hotWater;
	private String fridge;
	private String wifi;
	private String rating;

}
