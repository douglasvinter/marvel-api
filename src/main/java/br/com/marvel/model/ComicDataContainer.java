package br.com.marvel.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model representing Data Container for marvel characters. <br>
 * Endpoint representation <code>{gateway-marvel}/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataContainer implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The requested offset (number of skipped results) of the call.
	 */
	@JsonProperty("offset")
	private int offset;
	/**
	 * The requested result limit.
	 */
	@JsonProperty("limit")
	private int limit;
	/**
	 * The total number of resources available given the current filter set.
	 */
	@JsonProperty("total")
	private int total;
	/**
	 * The total number of results returned by this call.
	 */
	@JsonProperty("count")
	private int count;
	/**
	 * The list of comics returned by the call.
	 */
	@JsonProperty("results")
	private List<ComicModel> results;

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public int getTotal() {
		return total;
	}

	public int getCount() {
		return count;
	}

	public List<ComicModel> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "DataModel [offset=" + offset + ", limit=" + limit + ", total=" + total + ", count=" + count
				+ ", results=" + results + "]";
	}

}
