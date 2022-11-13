package br.com.alura.dayscode.api;

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

import br.com.alura.dayscode.model.Top250Result;
import br.com.alura.dayscode.rest.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoviesRestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private RestClient myAppClient;
	
	@Value("${imdb.api.key}")
	private String imdbApiKey;
	
	@Test
	void shouldReturnTop250Movies() {
		String resource = "http://localhost:" + port + "/api/movies/top?apiKey=" + imdbApiKey;
		
		ResponseEntity<Top250Result> response = myAppClient.request(resource, HttpMethod.GET, Top250Result.class);
		
		System.out.println(response.getBody().getErrorMessage());
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody().getItems());
	    assertEquals(response.getBody().getErrorMessage(), "");
	    assertEquals(response.getBody().getItems().size(), 250);

	}

}
