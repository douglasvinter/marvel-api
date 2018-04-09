package br.com.marvel.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.marvel.model.ComicModel;
import br.com.marvel.repository.ComicRepository;
import br.com.marvel.rest.client.exceptions.RestClientException;

/**
 * Service for marvel comics API
 * 
 * Endpoint representation: <br>
 * <code>{gateway-marvel}/comics</code>.
 * <code>{gateway-marvel}/comics/{comicId}</code>.
 * <code>{gateway-marvel}/characters/{characterId}/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 * 
 */

@Service
public class ComicService {

	@Autowired
	public ComicRepository comicRepository;

	/**
	 * Service logger
	 */
	protected final static Logger LOG = LoggerFactory.getLogger(ComicService.class);

	/**
	 * Retrieves {gateway-marvel}/comics data. The fall back for exceptions is check
	 * for existent cache data
	 * 
	 * @param comicId
	 *            marvel comic book Id
	 * @param refresh
	 *            force API data refresh instead of cached data
	 * @return Collection of marvel comics
	 */
	@Cacheable("comics")
	public List<ComicModel> getComics() {
		List<ComicModel> cm = null;

		try {
			cm = comicRepository.getComics();
		} catch (RestClientException | IOException e) {
			LOG.error(e.getMessage());
		}

		return (cm != null) ? cm : new ArrayList<ComicModel>();
	}

	/**
	 * Retrieves {gateway-marvel}/comics/{comicId} data. The fall back for
	 * exceptions is check for existent cache data
	 * 
	 * @param comicId
	 *            marvel comic book Id
	 * @param refresh
	 *            force API data refresh instead of cached data
	 * @return Single entity representing a marvel comic
	 */
	@Cacheable(value="comics", key="comic.id")
	public ComicModel getComicById(int comicId) {
		ComicModel cm = null;

		try {
			cm = comicRepository.getComicById(comicId);
		} catch (RestClientException | IOException e) {
			LOG.error(e.getMessage());
		}

		return (cm != null) ? cm : new ComicModel();
	}

	/**
	 * Retrieves {gateway-marvel}/characters/{characterId}/comics data. The fall
	 * back for exceptions is check for existent cache data
	 * 
	 * @param characterId
	 *            marvel character Id
	 * @param refresh
	 *            force API data refresh instead of cached data
	 * @return Collections of comics per character
	 */
	@Cacheable(value="comics", key="comic.character.id")
	public List<ComicModel> getComicsByCharacterId(int characterId) {
		List<ComicModel> cm = null;

		try {
			cm = comicRepository.getComicsByCharacterId(characterId);
		} catch (RestClientException | IOException e) {
			LOG.error(e.getMessage());
		}

		return (cm != null) ? cm : new ArrayList<ComicModel>();
	}
}
