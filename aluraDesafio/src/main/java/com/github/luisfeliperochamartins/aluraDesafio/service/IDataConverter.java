package com.github.luisfeliperochamartins.aluraDesafio.service;

import java.util.List;

public interface IDataConverter {
	<T> T getObject(String json, Class<T> clzz);
	<T> List<T> getObjectList(String json, Class<T> clzz);
}
