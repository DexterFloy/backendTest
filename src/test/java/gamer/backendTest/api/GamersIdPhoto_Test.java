package gamer.backendTest.api;

import static gamer.backendTest.api.utility.ValuesPropertiesHandling.getConfigProperties;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GamersIdPhoto_Test {

	private static Properties properties = getConfigProperties();
	private static WebTarget targetAPI;
	static Client client;

	@BeforeClass
	public static void setup() {
		client = ClientBuilder.newClient();
	}

	@Before
	public void buildCall() {
		targetAPI = client.target(properties.getProperty("targetSite", "targetSite") + "/gamer/"
				+ properties.getProperty("gamer_id", "gamer_id") + "/photo");
	}
	
	@Test
	public void testOcsTest_AthletesId_Photo() {
		byte[] response = targetAPI.request().get(byte[].class);
		assertNotNull(response);
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(response);
			BufferedImage image = ImageIO.read(bis);
			ImageIO.write(image, "jpg", new File("output.jpg"));
		} catch (IOException e) {
			fail("The response is not an image!");
		}
	}
	
}
