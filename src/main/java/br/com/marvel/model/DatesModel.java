package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("date")
	private String date;

	@JsonProperty("type")
	private String type;

	public String getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "DatesModel [date=" + date + ", type=" + type + "]";
	}

}
