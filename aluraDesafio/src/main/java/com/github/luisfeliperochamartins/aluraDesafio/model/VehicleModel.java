package com.github.luisfeliperochamartins.aluraDesafio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModel(@JsonProperty("Modelo") String name,
                           @JsonProperty("Valor") String value,
                           @JsonProperty("Combustivel") String fuel,
							@JsonProperty("AnoModelo") Integer year) {
}
