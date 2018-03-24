package br.com.marvel.resources;

import java.util.HashMap;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.marvel.services.MarvelService;

@Controller
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Marvel {

	@Autowired
	public MarvelService marvelService;

	@ResponseBody
	@RequestMapping(value = "/{message}", method = RequestMethod.GET)
	public HashMap<String, String> helloMarvel(@PathVariable("message") @NotNull String message) {
		return marvelService.helloMarvel(message);
	}

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<String, String> avengersAssemble() {
		return marvelService.avengerAssemble();
	}

}
