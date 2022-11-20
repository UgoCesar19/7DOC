package br.com.alura.dayscode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import br.com.alura.dayscode.model.Movie;
import br.com.alura.dayscode.model.Top250Result;
import br.com.alura.dayscode.rest.RestClient;

@Controller
@RequestMapping()
public class HomeController {

	@Autowired
	RestClient imdbClient;
	
	@Value("${imdb.api.base}")
	private String imdbApiBase;
	
	@Value("${imdb.api.top}")
	private String imdbApiTop;
	
	private List<Movie> topMovies = new ArrayList<>();
	private List<Movie> filteredMovies = new ArrayList<>();
	private List<Movie> favoriteMovies = new ArrayList<>();
	
	@GetMapping("home")
	public String home(@RequestParam String apiKey, @RequestParam(required = false) String title,  Model model) {
		
		if (topMovies.size() == 0) {
			String imdbResourceUrl = imdbApiBase + imdbApiTop + apiKey;
			
			ResponseEntity<Top250Result> response = imdbClient.request(imdbResourceUrl, HttpMethod.GET, Top250Result.class);
			
			topMovies = response.getBody().getItems();
		}
		
		if (Objects.nonNull(title)) {
			filteredMovies = topMovies.stream().filter(movie -> 
				movie.getTitle().toUpperCase().contains(title.toUpperCase())
			).collect(Collectors.toList());
		} else {
			filteredMovies = topMovies;
		}
		
		model.addAttribute("movies", filteredMovies);
		
		return "home"; 
	}
	
	@GetMapping("favoritos")
	public String favoritos(Model model) {
		
		favoriteMovies = topMovies.stream().filter(movie -> movie.getFavorito() == 1).collect(Collectors.toList());
		
		model.addAttribute("movies", favoriteMovies);
		
		return "home";
		
	}
	
	@GetMapping("favoritos/{movieId}")
	public RedirectView adicionarFavorito(@PathVariable String movieId) {
		Optional<Movie> favorite = topMovies.stream().filter(movie -> movie.getId().equalsIgnoreCase(movieId)).findFirst();
		
		if (favorite.isPresent()) {
            topMovies.get(topMovies.indexOf(favorite.get())).setFavorito(1);
        }
		
		return new RedirectView("/favoritos");
	}
	
	
	
}
