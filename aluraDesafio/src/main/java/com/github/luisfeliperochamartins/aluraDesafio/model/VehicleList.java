package com.github.luisfeliperochamartins.aluraDesafio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleList {

	@JsonProperty("modelos")
	private List<Vehicle> vehicles;

	public VehicleList() {

	}

	public VehicleList(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicleModels) {
		this.vehicles = vehicleModels;
	}
}
