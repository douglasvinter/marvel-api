package br.com.marvel.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.marvel.model.ComicDataWrapper;
import br.com.marvel.model.ComicModel;
import br.com.marvel.rest.client.MarvelRestClient;
import br.com.marvel.rest.client.exceptions.RestClientException;

/**
 * Marvel comics repository
 * 
 * Endpoint representation <code>{gateway-marvel}/comic</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@Repository
public class ComicRepository {
	/**
	 * Marvel rest client
	 */
	@Autowired	
	private MarvelRestClient client;

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	public List<ComicModel> getComics() throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = client.get("comics", ComicDataWrapper.class);

		return (cdw != null) ? cdw.getData().getResults() : new ArrayList<ComicModel>();
	}

	/**
	 * Returns an marvel comic
	 * 
	 * @param comicId
	 * @return Comic
	 * @throws RestClientException
	 * @throws IOException
	 */
	public ComicModel getComicById(int comicId) throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = client.get("comics/" + comicId, ComicDataWrapper.class);

		return (cdw.getData().getResults().size() > 0) ? cdw.getData().getResults().get(0) : new ComicModel();
	}

	/**
	 * Returns a collection of Marvel comics 
	 * 
	 * @param characterId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	public List<ComicModel> getComicsByCharacterId(int characterId) throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = client.get("characters/" + characterId + "/comics", ComicDataWrapper.class);

		return (cdw != null) ? cdw.getData().getResults() : new ArrayList<ComicModel>();
	}

}
