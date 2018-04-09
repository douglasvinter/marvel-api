package br.com.marvel.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.marvel.model.CharactersDataWrapper;
import br.com.marvel.model.CharactersModel;
import br.com.marvel.rest.client.MarvelRestClient;
import br.com.marvel.rest.client.exceptions.RestClientException;

/**
 * Marvel characters repository
 * 
 * Endpoint representation <code>{gateway-marvel}/characters</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@Repository
public class CharacterRepository {
	/**
	 * Marvel rest client
	 */
	@Autowired	
	private MarvelRestClient client;

	/**
	 * Returns a collection of Marvel characters
	 * 
	 * @return List of characters
	 * @throws RestClientException
	 * @throws IOException
	 */
	public List<CharactersModel> getCharacters() throws RestClientException, IOException {
		CharactersDataWrapper cdc = null;

		cdc = client.get("characters", CharactersDataWrapper.class);

		return (cdc != null) ? cdc.getData().getResults() : new ArrayList<CharactersModel>();
	}

	/**
	 * Returns an Marvel Character
	 * 
	 * @param characterId
	 * @return Character
	 * @throws RestClientException
	 * @throws IOException
	 */
	public CharactersModel getCharacterById(int characterId) throws RestClientException, IOException{
		CharactersDataWrapper cdc = null;

		cdc = client.get("characters/" + characterId, CharactersDataWrapper.class);

		return (cdc != null && cdc.getData().getResults().size() > 0) ? cdc.getData().getResults().get(0)
				: new CharactersModel();
	}

}
