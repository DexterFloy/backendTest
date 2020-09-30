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

import gamer.backendTest.api.dto.GamesResponse_DTO;

public class Games_Test {

	private static Properties properties = getConfigProperties();
	private static WebTarget targetAPI;
	static Client client;
	private List<GamesResponse_DTO> responseList;
	
		@BeforeClass
	public static void setup() {
		client = ClientBuilder.newClient();
	}

	@Before
	public void buildCall() {
		targetAPI = client.target(properties.getProperty("targetSite", "targetSite") + "/games");
		responseList = targetAPI.request().get(new GenericType<List<GamesResponse_DTO>>() {
		});
	}
	
	@Test
	public void test_Games_Game_id() {
		for (GamesResponse_DTO response : responseList) {
			assertNotNull(response.getGame_id());
		}
	}

	@Test
	public void test_Games_Wins() {
		for (GamesResponse_DTO response : responseList) {
			assertNotNull(response.getWins());
		}
	}

	@Test
	public void test_Games_Losses() {
		for (GamesResponse_DTO response : responseList) {
			assertNotNull(response.getLosses());
		}
	}
	
}
