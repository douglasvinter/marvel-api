package br.com.marvel.resources;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.marvel.model.CharactersModel;
import br.com.marvel.model.MarvelCharactersByComicModel;
import br.com.marvel.services.CharacterService;

@Controller
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Characters {

	@Autowired
	public CharacterService characterService;

	/**
	 * Simple comics request, forwards marvel characters API
	 * 
	 * @param refresh
	 *            forces services to refresh the existent cached data Accepted
	 *            value: true
	 * @return JSON Collection representation of CharactersModel
	 */
	@ResponseBody
	@RequestMapping(value = "/marvel/characters", method = RequestMethod.GET)
	public List<CharactersModel> characters() {
		return this.characterService.getCharacters();
	}

	/**
	 * This endpoint consumes two APIs and builds a Cartesian plan of marvel
	 * characters containing the comics he/she makes part of, which can be 1:N, each
	 * comic is a HTTP request.
	 * 
	 * @param refresh
	 *            forces services to refresh the existent cached data Accepted
	 *            value: true
	 * @return JSON Collection representation of MarvelCharactersByComicModel
	 */
	@ResponseBody
	@RequestMapping(value = "/marvel/characters/comics", method = RequestMethod.GET)
	public List<MarvelCharactersByComicModel> getComicsByCharacters() {
		return this.characterService.getAllCharactersInformation();
	}

}
