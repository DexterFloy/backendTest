package gamer.backendTest.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GamesResponse_DTO {

	private Integer game_id;
	private Integer wins;
	private Integer losses;
	
}
