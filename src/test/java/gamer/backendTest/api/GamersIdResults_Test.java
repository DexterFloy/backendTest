package gamer.backendTest.api;

import static gamer.backendTest.api.utility.ValuesPropertiesHandling.getConfigProperties;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gamer.backendTest.api.dto.GamersResultsResponse_DTO;

public class GamersIdResults_Test {

	private static Properties properties = getConfigProperties();
	private static WebTarget targetAPI;
	List<GamersResultsResponse_DTO> responseList;
	static Client client;
	
	@BeforeClass
	public static void setup() {
		client = ClientBuilder.newClient();
	}
	
	@Before
	public void buildCall() {
		targetAPI = client.target(properties.getProperty("targetSite", "targetSite") + "/gamer/"
				+ properties.getProperty("gamer_id", "gamer_id") + "/results");
		responseList = targetAPI.request().get(new GenericType<List<GamersResultsResponse_DTO>>() {
		});
	}
	
	@Test
	public void test_GamerIdResults_Wins() {
		for (GamersResultsResponse_DTO response : responseList) {
			assertNotNull(response.getWins());
		}
	}

	@Test
	public void test_GamerIdResults_Losses() {
		for (GamersResultsResponse_DTO response : responseList) {
			assertNotNull(response.getLosses());
		}
	}

	@Test
	public void test_GamerIdResults_Type_of_game() {
		for (GamersResultsResponse_DTO response : responseList) {
			assertNotNull(response.getType_of_game());
		}
	}

	@Test
	public void test_GamerIdResults_GameName() {
		for (GamersResultsResponse_DTO response : responseList) {
			assertNotNull(response.getGameName());
		}
	}
	
}
