package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;  

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceModel implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("price")
	private double price;

	@JsonProperty("type")
	private String type;

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "PriceModel [price=" + price + ", type=" + type + "]";
	}
}
