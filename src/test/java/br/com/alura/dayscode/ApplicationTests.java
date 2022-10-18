package br.com.alura.dayscode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldReturnTop250Films() {
		String apiKey = "";
		String imdbResourceUrl = "http://localhost:" + port + "/api/movies/top?apiKey=" + apiKey;
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> response = restTemplate.exchange(imdbResourceUrl, HttpMethod.GET, entity, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());

	}

}
