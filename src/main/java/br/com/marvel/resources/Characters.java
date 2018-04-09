package br.com.marvel.resources;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.marvel.model.CharactersModel;
import br.com.marvel.model.MarvelCharactersByComicModel;
import br.com.marvel.services.CharacterService;

@RestController
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Characters {

	@Autowired
	public CharacterService characterService;

	@GetMapping("marvel/characters")
	public List<CharactersModel> characters() {
		return this.characterService.getCharacters();
	}

	@GetMapping("marvel/characters/comics")
	public List<MarvelCharactersByComicModel> getComicsByCharacters() {
		return this.characterService.getAllCharactersInformation();
	}
	
	@GetMapping("marvel/characters/{characterId}")
	public CharactersModel getCharacterById(@NotNull @PathVariable("characterId") Integer characterId) {
		return this.characterService.getCharacterById(characterId);
	}

}
