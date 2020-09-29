package gamer.backendTest.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GamersResponse_DTO {

	private String gamer_id;
	private String nickname;
	private String dateOfBirth;
	private String bio;
	private Integer photo_id;
	
}