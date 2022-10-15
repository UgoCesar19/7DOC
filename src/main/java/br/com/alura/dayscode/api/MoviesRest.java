package br.com.alura.dayscode.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class MoviesRest {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("top")
	public String getTopMovies(@RequestParam String apiKey) {
		String imdbResourceUrl = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> response = restTemplate.exchange(imdbResourceUrl, HttpMethod.GET, entity, String.class);
		
		System.out.println(response.getBody().length());
		
		return response.getBody();
	}
	
}
