package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsListModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("resourceURI")
	private String resourceURI;

	public String getName() {
		return name;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	@Override
	public String toString() {
		return "ItemsListModel [name=" + name + ", resourceURI=" + resourceURI + "]";
	}
}
