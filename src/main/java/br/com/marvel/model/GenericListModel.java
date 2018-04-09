package br.com.marvel.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericListModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("available")
	private int available;

	@JsonProperty("collectionURI")
	private String collectionURI;

	@JsonProperty("items")
	private ArrayList<ItemsListModel> items;

	@JsonProperty("returned")
	private int returned;

	public int getAvailable() {
		return available;
	}

	public String getCollectionURI() {
		return collectionURI;
	}

	public ArrayList<ItemsListModel> getItems() {
		return items;
	}

	public int getReturned() {
		return returned;
	}
	
	@Override
	public String toString() {
		return "GenericListModel [available=" + available + ", collectionURI=" + collectionURI + ", items=" + items
				+ ", returned=" + returned + "]";
	}

}
