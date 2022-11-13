package br.com.alura.dayscode.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.alura.dayscode.model.Top250Result;

@SpringBootTest
class RestClientTest {

	@Autowired RestClient imdbClient;
	
	@Value("${imdb.api.base}")
	private String imdbApiBase;
	
	@Value("${imdb.api.top}")
	private String imdbApiTop;
	
	@Value("${imdb.api.key}")
	private String imdbApiKey;
	
	@Test
	void shouldReturnTop250MoviesFromImdb() {
		
		String imdbResourceUrl = imdbApiBase + imdbApiTop + imdbApiKey;
		
		ResponseEntity<Top250Result> response = imdbClient.request(imdbResourceUrl, HttpMethod.GET, Top250Result.class);
		
		System.out.println(response.getBody().getItems().get(0));
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		assertEquals(response.getBody().getItems().size(), 250);
		
	}

}
