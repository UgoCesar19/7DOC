package br.com.alura.dayscode.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {
	
	@Autowired
	private RestTemplate restTemplate;

	public <T> ResponseEntity<T> request(String resource, HttpMethod httpMethod, Class<T> responseType) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<T> response = restTemplate.exchange(resource, httpMethod, entity, responseType);

		return response;
	}
	
}
