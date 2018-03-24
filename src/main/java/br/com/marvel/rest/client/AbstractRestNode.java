package br.com.marvel.rest.client;

import java.io.Serializable;

/**
 * Abstract implementation of marvel rest client
 * 
 * @author dbranco
 */
public class AbstractRestNode implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	

	public static MarvelRestClient marvelRestClient;

	static {
		marvelRestClient = new MarvelRestClient();
	}

}
