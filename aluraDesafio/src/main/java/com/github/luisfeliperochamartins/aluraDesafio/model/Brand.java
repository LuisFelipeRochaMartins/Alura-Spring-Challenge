package com.github.luisfeliperochamartins.aluraDesafio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Brand(@JsonProperty("codigo") Integer code,
                    @JsonProperty("nome") String name) {
}
