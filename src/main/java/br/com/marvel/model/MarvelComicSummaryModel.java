package br.com.marvel.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model representing a summarized Comics Entity <br>
 * <code>{gateway-marvel}/characters/{characterId}/comics</code>. Endpoint
 * representation <code>{hands-on}/marvel/characters/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelComicSummaryModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Comic title
	 */
	@JsonProperty("title")
	private String title;
	/**
	 * History/adventure description
	 */
	@JsonProperty("description")
	private String description;
	/**
	 * Edition price
	 */
	@JsonProperty("price")
	private List<PriceModel> price;
	/**
	 * Isbn code
	 */
	@JsonProperty("isbn")
	private String isbn;
	/**
	 * Total of pages
	 */
	@JsonProperty("pageCount")
	private int pageCount;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<PriceModel> getPrice() {
		return price;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(List<PriceModel> price) {
		this.price = price;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "MarvelComicSummaryModel [title=" + title + ", description=" + description + ", price=" + price
				+ ", isbn=" + isbn + ", pageCount=" + pageCount + "]";
	}

}
