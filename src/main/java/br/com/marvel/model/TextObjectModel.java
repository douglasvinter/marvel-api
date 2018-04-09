package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextObjectModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("type")
	private String type;

	public String getLanguage() {
		return language;
	}

	public String getText() {
		return text;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "TextObjectModel [language=" + language + ", text=" + text + ", type=" + type + "]";
	}

}
