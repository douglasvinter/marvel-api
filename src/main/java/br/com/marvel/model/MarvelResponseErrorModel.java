package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponseErrorModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final String UNKNOW_API_ERROR = "Unknow API error";
	
	@JsonProperty("code") 
	private String code;

	@JsonProperty("message")
	private String message;

	public String getErrorCode() {
		return code;
	}

	public String getErrorMessage() {
		return (message != null && !message.isEmpty()) 
				? message : UNKNOW_API_ERROR;
	}

	@Override
	public String toString() {
		return "{code: " + code + ", message: " + message + "}";
	}
}
