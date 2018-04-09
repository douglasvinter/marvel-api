package br.com.marvel.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.marvel.model.CharactersModel;
import br.com.marvel.model.ComicModel;
import br.com.marvel.model.MarvelCharactersByComicModel;
import br.com.marvel.model.MarvelComicSummaryModel;
import br.com.marvel.model.PriceModel;
import br.com.marvel.repository.CharacterRepository;
import br.com.marvel.repository.ComicRepository;
import br.com.marvel.rest.client.exceptions.RestClientException;

/**
 * Service for marvel character API
 * 
 * Endpoint representation: <br>
 * <code>{gateway-marvel}/characters</code>.
 * <code>{gateway-marvel}/characters/{characterId}</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 * 
 */
@Service
public class CharacterService {

	@Autowired
	public ComicRepository comicRepository;

	@Autowired
	public CharacterRepository characterRepository;

	/**
	 * Service logger
	 */
	protected final static Logger LOG = LoggerFactory.getLogger(CharacterService.class);

	@Cacheable("characters")
	public List<CharactersModel> getCharacters() {
		List<CharactersModel> cm = null;

		try {
			cm = characterRepository.getCharacters();
		} catch (RestClientException | IOException e) {
			LOG.error(e.getMessage());
		}

		return cm != null ? cm : new ArrayList<CharactersModel>();
	}

	@Cacheable(value="characters", key="#character.id")
	public CharactersModel getCharacterById(int characterId) {
		CharactersModel cm = null;

		try {
			cm = characterRepository.getCharacterById(characterId);
		} catch (RestClientException | IOException e) {
			LOG.error(e.getMessage());
		}

		return (cm != null) ? cm : new CharactersModel();
	}

	/**
	 * Fetches the whole characters API and checks for existing comics that this
	 * character makes part of.
	 * 
	 * @param refresh
	 *            force services refresh instead of using cached data
	 * @return Collections of custom Entity, containing a summary of the character
	 *         and the comics this characters makes part of, if any.
	 */
	@Cacheable("charactersInProducts")
	public List<MarvelCharactersByComicModel> getAllCharactersInformation() {
		List<CharactersModel> characters = this.getCharacters();
		List<MarvelCharactersByComicModel> cbc = new ArrayList<MarvelCharactersByComicModel>();

		if (characters != null) {
			for (CharactersModel cm : characters) {
				MarvelCharactersByComicModel mcbcm = new MarvelCharactersByComicModel();
				mcbcm.setName(cm.getName());
				mcbcm.setDescription(cm.getDescription());
				mcbcm.setThumbnail(cm.getThumbnail());
				List<ComicModel> c = null;
				try {
					c = this.comicRepository.getComicsByCharacterId(cm.getId());
				} catch (RestClientException | IOException e) {
					LOG.error(e.getMessage());
				}

				if (c != null) {
					double tp = mcbcm.getTotalPriceForCharacterComics();
					for (ComicModel comic : c) {
						MarvelComicSummaryModel mcsm = new MarvelComicSummaryModel();
						mcsm.setTitle(comic.getTitle());
						mcsm.setDescription(comic.getDescription());
						mcsm.setPrice(comic.getPrices());

						for (PriceModel p : comic.getPrices()) {
							tp += p.getPrice();
						}

						mcbcm.setTotalPriceForCharacterComics(tp);
						mcsm.setIsbn(comic.getIsbn());
						mcsm.setPageCount(comic.getPageCount());
						mcbcm.addComics(mcsm);
					}

					
				}
				cbc.add(mcbcm);
			}
		}

		return cbc;
	}
}
