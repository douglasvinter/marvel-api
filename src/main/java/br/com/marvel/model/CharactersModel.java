package br.com.marvel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model representing Characters from marvel comics. <br>
 * Endpoint representation <code>{gateway-marvel}/characters</code>.
 * CharacterDataWrapper["data"] ->
 * CharacterDataContainer["results"]->CharactersModel <br>
 * 
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The unique ID of the character resource.
	 */
	@JsonProperty("id")
	private int id;
	/**
	 * The name of the character.
	 */
	@JsonProperty("name")
	private String name;
	/**
	 * A short bio or description of the character.
	 */
	@JsonProperty("description")
	private String description;
	/**
	 * The date the resource was most recently modified.
	 */
	@JsonProperty("modified")
	/**
	 * Date modified;
	 */
	private String modified;
	/**
	 * The canonical URL identifier for this resource.
	 */
	@JsonProperty("resourceURI")
	private String resourceURI;
	/**
	 * A set of public web site URLs for the resource.
	 */
	@JsonProperty("urls")
	private List<GenericUrlModel> urls;
	/**
	 * The representative image for this character.
	 */
	@JsonProperty("thumbnail")
	private ThumbnailModel thumbnail;
	/**
	 * A resource list containing comics which feature this character.
	 */
	@JsonProperty("comics")
	private GenericListModel comics;
	/**
	 * A resource list of stories in which this character appears.
	 */
	@JsonProperty("stories")
	private GenericListModel stories;
	/**
	 * A resource list of events in which this character appears.
	 */
	@JsonProperty("events")
	private GenericListModel events;
	/**
	 * A resource list of series in which this character appears.
	 */
	@JsonProperty("series")
	private GenericListModel series;

	public int getId() {
		return id;
	}

	public String getName() {
		return (name != null) ? name : "";
	}

	public String getDescription() {
		return (description != null) ? description : "";
	}

	public String getModified() {
		return (modified != null) ? modified : "";
	}

	public String getResourceURI() {
		return (resourceURI != null) ? resourceURI : "";
	}

	public List<GenericUrlModel> getUrls() {
		if (urls == null) {
			urls = new ArrayList<GenericUrlModel>();
		}
		return urls;
	}

	public ThumbnailModel getThumbnail() {
		if (thumbnail == null) {
			thumbnail = new ThumbnailModel();
		}

		return thumbnail;
	}

	public GenericListModel getComics() {
		if (comics == null) {
			comics = new GenericListModel();
		}

		return comics;
	}

	public GenericListModel getStories() {
		if (stories == null) {
			stories = new GenericListModel();
		}

		return stories;
	}

	public GenericListModel getEvents() {
		if (events == null) {
			events = new GenericListModel();
		}

		return events;
	}

	public GenericListModel getSeries() {
		if (series == null) {
			series = new GenericListModel();
		}

		return series;
	}

	@Override
	public String toString() {
		return "CharactersModel [id=" + id + ", name=" + name + ", description=" + description + ", modified="
				+ modified + ", resourceURI=" + resourceURI + ", urls=" + urls + ", thumbnail=" + thumbnail
				+ ", comics=" + comics + ", stories=" + stories + ", events=" + events + ", series=" + series + "]";
	}
}
