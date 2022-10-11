package com.testyantra.user.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
/**
 * @author Sameer Balehosur
 *
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(value = Include.NON_DEFAULT)
public class HotelResponse {
	private String statusCode;
	private String statusDescription;
	private String deletedData;
	private String feedback;
}
