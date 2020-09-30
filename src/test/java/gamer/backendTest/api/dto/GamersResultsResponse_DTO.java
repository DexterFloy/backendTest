package gamer.backendTest.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GamersResultsResponse_DTO {

	private Integer wins;
	private Integer losses;
	private String type_of_game;
	private String gameName;
	
}
