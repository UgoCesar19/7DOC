package br.com.alura.dayscode.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.dayscode.model.Top250Result;
import br.com.alura.dayscode.rest.RestClient;

@RestController
@RequestMapping("/api/movies")
public class MoviesRest {

	@Autowired RestClient imdbClient;
	
	@Value("${imdb.api.base}")
	private String imdbApiBase;
	
	@Value("${imdb.api.top}")
	private String imdbApiTop;
	
	@GetMapping("top")
	public Top250Result getTopMovies(@RequestParam String apiKey) {
		String imdbResourceUrl = imdbApiBase + imdbApiTop + apiKey;
		
		ResponseEntity<Top250Result> response = imdbClient.request(imdbResourceUrl, HttpMethod.GET, Top250Result.class);
		
		return response.getBody();
	}
	
}
