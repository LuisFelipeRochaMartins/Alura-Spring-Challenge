package com.github.luisfeliperochamartins.aluraDesafio.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestHandler {

	/**
	 * Makes a request to the url in parameter
	 *
	 * @param url String
	 * @return String
	 */
	public String getData(String url) {
		HttpClient client   = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response = null;

		try{
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		return response.body();
	}
}
