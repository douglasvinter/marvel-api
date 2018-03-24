package br.com.marvel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarvelConfig {
	public static String API_PUBLIC_KEY;
	public static String API_PRIVATE_KEY;
	

    @Value("${marvel.api.publicKey}")
    public void setPublicKey(String publicKey) {
    	API_PUBLIC_KEY = publicKey;
    }
    
    @Value("${marvel.api.privateKey}")
    public void setPrivateKey(String privateKey) {
    	API_PRIVATE_KEY = privateKey;
    }
}
