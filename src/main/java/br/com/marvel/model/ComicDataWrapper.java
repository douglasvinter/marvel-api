
package br.com.marvel.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model representing Data Wrapper for marvel comics. <br>
 * Endpoint representation <code>{gateway-marvel}/comics</code>.
 *
 * @author <a href="douglasvinter@gmail.com">Douglas</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicDataWrapper implements Serializable {
	/**
	 * Serializer version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The HTTP status code of the returned result.,
	 */
	@JsonProperty("code")
	private int code;
	/**
	 * A string description of the call status.
	 */
	@JsonProperty("status")
	private String status;
	/**
	 * The copyright notice for the returned result.
	 */
	@JsonProperty("copyright")
	private String copyright;
	/**
	 * The attribution notice for this result. Please display either this notice
	 * or the contents of the attributionHTML field on all screens which contain
	 * data from the Marvel Comics API.
	 */
	@JsonProperty("attributionText")
	private String attributionText;
	/**
	 * An HTML representation of the attribution notice for this result. Please
	 * display either this notice or the contents of the attributionText field
	 * on all screens which contain data from the Marvel Comics API.
	 */
	@JsonProperty("attributionHTML")
	private String attributionHTML;
	/**
	 * A digest value of the content returned by the call.
	 */
	@JsonProperty("etag")
	private String etag;
	/**
	 * The results returned by the call.
	 */
	@JsonProperty("data")
	private ComicDataContainer data;

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public String getEtag() {
		return etag;
	}

	public ComicDataContainer getData() {
		return data;
	}

	@Override
	public String toString() {
		return "ComicDataWrapper [code=" + code + ", status=" + status + ", copyright=" + copyright
				+ ", attributionText=" + attributionText + ", attributionHTML=" + attributionHTML + ", etag=" + etag
				+ ", data=" + data + "]";
	}
}
