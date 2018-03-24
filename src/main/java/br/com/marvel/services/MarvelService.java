package br.com.marvel.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class MarvelService {
	
	@SuppressWarnings("serial")
	public HashMap<String, String> helloMarvel(final String message) {
		return new HashMap<String, String> () {
			{
				put("Hello", message);
			}
		};
	}
	
	@SuppressWarnings("serial")
	public HashMap<String, String> avengerAssemble() {
		return new HashMap<String, String> () {
			{
				put("Avengers", "Assemble");
			}
		};
	}

}
