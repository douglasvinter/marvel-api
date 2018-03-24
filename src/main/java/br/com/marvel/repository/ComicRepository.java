package br.com.marvel.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.marvel.model.ComicDataWrapper;
import br.com.marvel.model.ComicModel;
import br.com.marvel.rest.client.AbstractRestNode;
import br.com.marvel.rest.client.RestClientException;

@Repository
public class ComicRepository {

	public List<ComicModel> getComics() throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = AbstractRestNode.marvelRestClient.get("comics", ComicDataWrapper.class);

		return (cdw != null) ? cdw.getData().getResults() : new ArrayList<ComicModel>();
	}

	public ComicModel getComicById(int comicId) throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = AbstractRestNode.marvelRestClient.get("comics/" + comicId, ComicDataWrapper.class);

		return (cdw.getData().getResults().size() > 0) ? cdw.getData().getResults().get(0) : new ComicModel();
	}

	public List<ComicModel> getComicsByCharacterId(int characterId) throws RestClientException, IOException {
		ComicDataWrapper cdw = null;

		cdw = AbstractRestNode.marvelRestClient.get("characters/" + characterId + "/comics", ComicDataWrapper.class);

		return (cdw != null) ? cdw.getData().getResults() : new ArrayList<ComicModel>();
	}

}
