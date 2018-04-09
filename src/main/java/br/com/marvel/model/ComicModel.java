package br.com.marvel.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model representing a marvel comic entity. <br>
 * Endpoint representation <code>{gateway-marvel}/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicModel implements Serializable {
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
	 * The ID of the digital comic representation of this comic. Will be 0 if
	 * the comic is not available digitally
	 */
	@JsonProperty("digitalId")
	private int digitalId;
	/**
	 * The canonical title of the comic
	 */
	@JsonProperty("title")
	private String title;
	/**
	 * The number of the issue in the series (will generally be 0 for collection
	 * formats).,
	 */
	@JsonProperty("issueNumber")
	private double issueNumber;
	/**
	 * If the issue is a variant (e.g. an alternate cover, second printing, or
	 * director’s cut), a text description of the variant
	 */
	@JsonProperty("variantDescription")
	private String variantDescription;
	/**
	 * The preferred description of the comic
	 */
	@JsonProperty("description")
	private String description;
	/**
	 * The date the resource was most recently modified
	 */
	@JsonProperty("modified")
	private String modified;
	/**
	 * The ISBN for the comic (generally only populated for collection formats)
	 */
	@JsonProperty("isbn")
	private String isbn;
	/**
	 * The UPC barcode number for the comic (generally only populated for
	 * periodical formats)
	 */
	@JsonProperty("upc")
	private String upc;
	/**
	 * The Diamond code for the comic
	 */
	@JsonProperty("diamondCode")
	private String diamondCode;
	/**
	 * The EAN barcode for the comic
	 */
	@JsonProperty("ean")
	private String ean;
	/**
	 * The ISSN barcode for the comic
	 */
	@JsonProperty("issn")
	private String issn;
	/**
	 * The publication format of the comic e.g. comic, hardcover, trade
	 * paperback
	 */
	@JsonProperty("format")
	private String format;
	/**
	 * The number of story pages in the comic
	 */
	@JsonProperty("pageCount")
	private int pageCount;
	/**
	 * A set of descriptive text blurbs for the comic
	 */
	@JsonProperty("textObjects")
	private List<TextObjectModel> textObjects;
	/**
	 * The canonical URL identifier for this resource
	 */
	@JsonProperty("resourceURI")
	private String resourceURI;
	/**
	 * A set of public web site URLs for the resource
	 */
	@JsonProperty("urls")
	private List<GenericUrlModel> urls;
	/**
	 * A summary representation of the series to which this comic belongs
	 */
	@JsonProperty("series")
	private ItemsListModel series;

	/**
	 * A list of variant issues for this comic (includes the "original" issue if
	 * the current issue is a variant)
	 */
	@JsonProperty("variants")
	private List<GenericListModel> variants;
	/**
	 * A list of collections which include this comic (will generally be empty
	 * if the comic's format is a collection)
	 */
	@JsonProperty("collections")
	private List<GenericListModel> collections;

	/**
	 * A list of issues collected in this comic (will generally be empty for
	 * periodical formats such as "comic" or "magazine")
	 */
	@JsonProperty("collectedIssues")
	private List<GenericListModel> collectedIssues;
	/**
	 * A list of key dates for this comic
	 */
	@JsonProperty("dates")
	private List<DatesModel> dates;
	/**
	 * A list of prices for this comic
	 */
	@JsonProperty("prices")
	private List<PriceModel> prices;
	/**
	 * The representative image for this comic
	 */
	@JsonProperty("thumbnail")
	private ThumbnailModel thumbnail;
	/**
	 * list of promotional images associated with this comic
	 */
	@JsonProperty("images")
	private List<ThumbnailModel> images;
	/**
	 * A resource list containing the creators associated with this comic
	 */
	@JsonProperty("creators")
	private GenericListModel creators;
	/**
	 * A resource list containing the characters which appear in this comic
	 */
	@JsonProperty("characters")
	private GenericListModel characters;
	/**
	 * A resource list containing the stories which appear in this comic
	 */
	@JsonProperty("stories")
	private GenericListModel stories;
	/**
	 * A resource list containing the events in which this comic appears
	 */
	@JsonProperty("events")
	private GenericListModel events;

	public int getId() {
		return id;
	}

	public int getDigitalId() {
		return digitalId;
	}

	public String getTitle() {
		return title;
	}

	public double getIssueNumber() {
		return issueNumber;
	}

	public String getVariantDescription() {
		return variantDescription;
	}

	public String getDescription() {
		return description;
	}

	public String getModified() {
		return modified;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getUpc() {
		return upc;
	}

	public String getDiamondCode() {
		return diamondCode;
	}

	public String getEan() {
		return ean;
	}

	public String getIssn() {
		return issn;
	}

	public String getFormat() {
		return format;
	}

	public int getPageCount() {
		return pageCount;
	}

	public List<TextObjectModel> getTextObjects() {
		return textObjects;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public List<GenericUrlModel> getUrls() {
		return urls;
	}

	public ItemsListModel getSeries() {

		return series;
	}

	public List<GenericListModel> getVariants() {
		return variants;
	}

	public List<GenericListModel> getCollections() {
		return collections;
	}

	public List<GenericListModel> getCollectedIssues() {
		return collectedIssues;
	}

	public List<DatesModel> getDates() {
		return dates;
	}

	public List<PriceModel> getPrices() {
		return prices;
	}

	public ThumbnailModel getThumbnail() {
		return thumbnail;
	}

	public List<ThumbnailModel> getImages() {
		return images;
	}

	public GenericListModel getCreators() {
		return creators;
	}

	public GenericListModel getCharacters() {
		return characters;
	}

	public GenericListModel getStories() {
		return stories;
	}

	public GenericListModel getEvents() {
		return events;
	}

	@Override
	public String toString() {
		return "ComicModel [id=" + id + ", digitalId=" + digitalId + ", title=" + title + ", issueNumber=" + issueNumber
				+ ", variantDescription=" + variantDescription + ", description=" + description + ", modified="
				+ modified + ", isbn=" + isbn + ", upc=" + upc + ", diamondCode=" + diamondCode + ", ean=" + ean
				+ ", issn=" + issn + ", format=" + format + ", pageCount=" + pageCount + ", textObjects=" + textObjects
				+ ", resourceURI=" + resourceURI + ", urls=" + urls + ", series=" + series + ", variants=" + variants
				+ ", collections=" + collections + ", collectedIssues=" + collectedIssues + ", dates=" + dates
				+ ", prices=" + prices + ", thumbnail=" + thumbnail + ", images=" + images + ", creators=" + creators
				+ ", characters=" + characters + ", stories=" + stories + ", events=" + events + "]";
	}
}
