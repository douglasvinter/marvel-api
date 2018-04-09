package br.com.marvel.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Model representing two Marvel APIs requests <br>
 * <code>{gateway-marvel}/characters</code>.
 * <code>{gateway-marvel}/characters/{characterI}/comics</code>.
 * Endpoint representation <code>{hands-on}/marvel/characters/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCharactersByComicModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Marvel character name
	 */
	@JsonProperty("name")
	private String name;
	/**
	 * Marvel character bio description
	 */
	@JsonProperty("description")
	private String description;
	/**
	 * Marvel character avatar hyperlink object
	 */
	@JsonProperty("thumbnail")
	private ThumbnailModel thumbnail;
	/**
	 * Comics that the characters appears Relationship 1:N
	 */
	@JsonProperty("comics")
	@JsonInclude(Include.ALWAYS)
	private List<MarvelComicSummaryModel> comics;
	/**
	 * Total cost to purchased all available comics series for the current
	 * characters, can be any type (digital, print etc)
	 */
	@JsonProperty("totalPriceForCharacterComics")
	private double totalPriceForCharacterComics;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ThumbnailModel getThumbnail() {
		return thumbnail;
	}

	public List<MarvelComicSummaryModel> getComics() {
		return comics;
	}

	public double getTotalPriceForCharacterComics() {
		return totalPriceForCharacterComics;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setThumbnail(ThumbnailModel thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setComics(List<MarvelComicSummaryModel> comics) {
		this.comics = comics;
	}

	public void addComics(MarvelComicSummaryModel comics) {
		this.comics.add(comics);
	}

	public void setTotalPriceForCharacterComics(double totalPriceForCharacterComics) {
		this.totalPriceForCharacterComics = totalPriceForCharacterComics;
	}

	@Override
	public String toString() {
		return "MarvelCharactersByComicModel [name=" + name + ", description=" + description + ", thumbnail="
				+ thumbnail + ", comics=" + comics + ", totalPriceForCharacterComics=" + totalPriceForCharacterComics
				+ "]";
	}

}
