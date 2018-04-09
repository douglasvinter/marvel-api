package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThumbnailModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("extension")
	private String extension;

	@JsonProperty("path")
	private String path;
	
	public String getExtension() {
		return extension;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "ThumbnailModel [extension=" + extension + ", path=" + path + "]";
	}
}
