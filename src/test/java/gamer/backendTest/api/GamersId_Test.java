package gamer.backendTest.api;

import static gamer.backendTest.api.utility.ValuesPropertiesHandling.getConfigProperties;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gamer.backendTest.api.dto.GamersResponse_DTO;

public class GamersId_Test {
	private static Properties properties = getConfigProperties();
	private static WebTarget targetAPI;
	static Client client;
	private GamersResponse_DTO response;
	
	@BeforeClass
	public static void setup() {
		client = ClientBuilder.newClient();
	}

	@Before
	public void buildCall() {
		targetAPI = client.target(properties.getProperty("targetSite", "targetSite") + "/gamer/"
				+ properties.getProperty("gamer_id", "gamer_id"));
		response = targetAPI.request().get(GamersResponse_DTO.class);
	}

	@Test
	public void test_GamerId_gamer_id() {
		assertNotNull(response.getGamer_id());
	}

	@Test
	public void test_GamerId_nickname() {
		assertNotNull(response.getNickname());
	}

	@Test
	public void test_GamerId_dateOfBirth() {
		assertNotNull(response.getDateOfBirth());
	}

	@Test
	public void test_GamerId_bio() {
		assertNotNull(response.getBio());
	}

	@Test
	public void test_GamerId_photo_id() {
		assertNotNull(response.getPhoto_id());
	}
	
}
