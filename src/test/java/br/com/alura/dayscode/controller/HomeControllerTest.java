package br.com.alura.dayscode.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.alura.dayscode.rest.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private RestClient myAppClient;
	
	@Value("${imdb.api.key}")
	private String imdbApiKey;
	
	@Test
	void test() {

		String resource = "http://localhost:" + port + "/home?apiKey=" + imdbApiKey;
		
		ResponseEntity<String> response = myAppClient.request(resource, HttpMethod.GET, String.class);
		
		String favorite1 = "http://localhost:" + port + "/favoritos/tt0111161";
		String favorite2 = "http://localhost:" + port + "/favoritos/tt0068646";
		String favorite3 = "http://localhost:" + port + "/favoritos/tt10872600";
		
		response = myAppClient.request(favorite1, HttpMethod.GET, String.class);
		response = myAppClient.request(favorite2, HttpMethod.GET, String.class);
		response = myAppClient.request(favorite3, HttpMethod.GET, String.class);
		
		String favorites = "http://localhost:" + port + "/favoritos";
		
		response = myAppClient.request(favorites, HttpMethod.GET, String.class);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
		
	}

}
