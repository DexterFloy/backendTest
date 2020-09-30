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

import gamer.backendTest.api.dto.GamersResponse_DTO;

public class GamesIdGamers_Test {

	private static Properties properties = getConfigProperties();
	private static WebTarget targetAPI;
	static Client client;
	private List<GamersResponse_DTO> responseList;

	@BeforeClass
	public static void setup() {
		client = ClientBuilder.newClient();
	}

	@Before
	public void buildCall() {
		targetAPI = client.target(properties.getProperty("targetSite", "targetSite") + "/games/"
				+ properties.getProperty("game_id", "game_id") + "/gamers");
		responseList = targetAPI.request().get(new GenericType<List<GamersResponse_DTO>>() {
		});
	}

	@Test
	public void test_GamesIdGamers_Gamer_id() {
		for (GamersResponse_DTO response : responseList) {
			assertNotNull(response.getGamer_id());
		}
	}

	@Test
	public void test_GamesIdGamers_Nickname() {
		for (GamersResponse_DTO response : responseList) {
			assertNotNull(response.getNickname());
		}
	}

	@Test
	public void test_GamesIdGamers_Photo_id() {
		for (GamersResponse_DTO response : responseList) {
			assertNotNull(response.getPhoto_id());
		}
	}

	@Test
	public void test_GamesIdGamers_DateOfBirth() {
		for (GamersResponse_DTO response : responseList) {
			assertNotNull(response.getDateOfBirth());
		}
	}

	@Test
	public void test_GamesIdGamers_Bio() {
		for (GamersResponse_DTO response : responseList) {
			assertNotNull(response.getBio());
		}
	}
	
}
