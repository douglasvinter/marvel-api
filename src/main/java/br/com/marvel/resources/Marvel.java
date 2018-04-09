package br.com.marvel.resources;

import java.util.HashMap;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.marvel.services.MarvelService;

@RestController
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Marvel {

	@Autowired
	public MarvelService marvelService;

	@GetMapping("/{message}")
	public HashMap<String, String> helloMarvel(@PathVariable("message") @NotNull String message) {
		return marvelService.helloMarvel(message);
	}

	@GetMapping("/")
	public HashMap<String, String> avengersAssemble() {
		return marvelService.avengerAssemble();
	}

}
