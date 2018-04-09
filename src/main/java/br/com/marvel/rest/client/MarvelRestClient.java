package br.com.marvel.rest.client;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.marvel.config.MarvelConfig;
import br.com.marvel.model.MarvelResponseErrorModel;
import br.com.marvel.rest.client.exceptions.RestClientException;

@Component
public class MarvelRestClient {
	/**
	 * API public key
	 */
	private final String publicKey;
	/**
	 * API private key
	 */
	private final String privateKey;
	/**
	 * Base API URI
	 */
	private final String BASE_API_URI = "http://gateway.marvel.com/v1/public";
	/**
	 * Default API result limit
	 */
	private final int DEFAULT_API_RESULT_LIMIT = 20;
	/**
	 * Jackson mapper
	 */
	private ObjectMapper objectMapper;
	/**
	 * Client Logger
	 */
	protected final static Logger LOG = LoggerFactory.getLogger(MarvelRestClient.class);

	public MarvelRestClient() {
		this.publicKey = MarvelConfig.API_PUBLIC_KEY;
		this.privateKey = MarvelConfig.API_PRIVATE_KEY;
		objectMapper = new ObjectMapper();
		// Custom Headers
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
	}

	/**
	 * Performs HTTP GET accordingly to the API standards with the basic
	 * requirements
	 * 
	 * 
	 * @param endpoint
	 *            target API endpoint
	 * @param targetClass
	 *            marshaller for data serialization
	 * @return Serialized response for requested API endpoint
	 * 
	 * @throws RestClientException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public <T> T get(String endpoint, Class<T> targetClass)
			throws RestClientException, JsonParseException, JsonMappingException, IOException {

		final WebTarget wt = buildRequestFor(endpoint);
		
		LOG.info("Fetching request for endpoint: " + wt.getUri().toString());

		Invocation.Builder ib = wt.request(MediaType.APPLICATION_JSON);
		Response response = ib.get();

		ib.header("Accept-Encoding", "gzip/deflate");
		LOG.info("Http response status code: " + String.valueOf(response.getStatus()));

		if (response.getStatus() != 200) {
			String json = response.readEntity(String.class);
			MarvelResponseErrorModel mrem = objectMapper.readValue(json, MarvelResponseErrorModel.class);
			throw new RestClientException(mrem.toString());
		}

		String json = response.readEntity(String.class);
		LOG.info(json);
		return objectMapper.readValue(json, targetClass);
	}
	
	
	private WebTarget buildRequestFor(final String endpoint) throws RestClientException{
		Client client = ClientBuilder.newClient();
		long ts = System.currentTimeMillis();
		String dk = generateDigestHash(ts);

		if (dk == null) {
			throw new RestClientException("Unsupported environment");
		}
		return client.target(BASE_API_URI).path(endpoint).queryParam("ts", ts)
				.queryParam("apikey", publicKey).queryParam("hash", dk).queryParam("limit", DEFAULT_API_RESULT_LIMIT);
	}

	/**
	 * Generates hash key for API access
	 * 
	 * @param timestamp
	 *            current time in msec
	 * @param publicKey
	 *            API public key
	 * @param privateKey
	 *            API private key
	 * @return hash digest using MD5 algo
	 */
	private String generateDigestHash(long timestamp) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String toHash = timestamp + privateKey + publicKey;
			return new BigInteger(1, md.digest(toHash.getBytes())).toString(16);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("MD5 Algorithm is not supported in the current JVM/JDK");
		}

		return null;
	}
}
