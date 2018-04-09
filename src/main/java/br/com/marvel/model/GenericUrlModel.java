package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericUrlModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;
	
	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "GenericUrlModel [type=" + type + ", url=" + url + "]";
	}
}
