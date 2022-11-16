package br.com.alura.dayscode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.dayscode.model.Movie;
import br.com.alura.dayscode.model.Top250Result;
import br.com.alura.dayscode.rest.RestClient;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	RestClient imdbClient;
	
	@Value("${imdb.api.base}")
	private String imdbApiBase;
	
	@Value("${imdb.api.top}")
	private String imdbApiTop;
	
	@GetMapping()
	public String home(@RequestParam String apiKey, Model model) {
		
		String imdbResourceUrl = imdbApiBase + imdbApiTop + apiKey;
		
		ResponseEntity<Top250Result> response = imdbClient.request(imdbResourceUrl, HttpMethod.GET, Top250Result.class);
		
		List<Movie> movies = response.getBody().getItems();
		model.addAttribute("movies", movies);
		
		return "home"; 
	}
	
}
