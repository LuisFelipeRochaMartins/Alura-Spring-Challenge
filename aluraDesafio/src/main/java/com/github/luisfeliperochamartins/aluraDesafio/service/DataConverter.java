package com.github.luisfeliperochamartins.aluraDesafio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataConverter implements IDataConverter {

	private final ObjectMapper mapper = new ObjectMapper();

	public <T> T getObject(String json, Class<T> clzz) {
		try {
			return mapper.readValue(json, clzz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> List<T> getObjectList(String json, Class<T> clzz) {
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clzz));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}