package br.com.marvel.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.marvel.model.CharactersDataWrapper;
import br.com.marvel.model.CharactersModel;
import br.com.marvel.rest.client.AbstractRestNode;
import br.com.marvel.rest.client.RestClientException;

@Repository
public class CharacterRepository {

	public List<CharactersModel> getCharacters() throws RestClientException, IOException {
		CharactersDataWrapper cdc = null;
		cdc = AbstractRestNode.marvelRestClient.get("characters", CharactersDataWrapper.class);

		return (cdc != null) ? cdc.getData().getResults() : new ArrayList<CharactersModel>();
	}

	public CharactersModel getCharacterById(int characterId) throws RestClientException, IOException{
		CharactersDataWrapper cdc = null;

		cdc = AbstractRestNode.marvelRestClient.get("characters/" + characterId, CharactersDataWrapper.class);

		return (cdc != null && cdc.getData().getResults().size() > 0) ? cdc.getData().getResults().get(0)
				: new CharactersModel();
	}

}
