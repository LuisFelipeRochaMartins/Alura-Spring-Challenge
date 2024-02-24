package com.github.luisfeliperochamartins.aluraDesafio.principal;

import com.github.luisfeliperochamartins.aluraDesafio.model.Brand;
import com.github.luisfeliperochamartins.aluraDesafio.model.Vehicle;
import com.github.luisfeliperochamartins.aluraDesafio.model.VehicleModel;
import com.github.luisfeliperochamartins.aluraDesafio.model.VehicleList;
import com.github.luisfeliperochamartins.aluraDesafio.service.DataConverter;
import com.github.luisfeliperochamartins.aluraDesafio.service.RequestHandler;

import java.util.*;
import java.util.stream.Collectors;

public final class Principal {

	private final RequestHandler handler  = new RequestHandler();
	private final DataConverter converter = new DataConverter();
	private final Scanner input = new Scanner(System.in);
	private String API = "https://parallelum.com.br/fipe/api/v1/";

	/**
	 * Show the main menu of the api.
	 */
	public void showMenu() {
		List<Brand> brands =  this.getVehicleType();

		System.out.println("List of all brands found:");
		brands.stream()
				.sorted(Comparator.comparing(Brand::code))
				.forEach(b -> System.out.println(b.code() + " " + b.name()));

		System.out.println("List of all car found: ");
		List<Vehicle> vehicles = this.getVehiclesByBrand();
		vehicles.stream().sorted(Comparator.comparing(Vehicle::code))
				.forEach(v -> System.out.println(v.code() + " " + v.name()));

		List<Vehicle> filteredVehiclesNames = this.getVehicleByName(vehicles);
		filteredVehiclesNames.forEach(System.out::println);

		List<VehicleModel> models = new ArrayList<>();
		List<Vehicle> filteredVehicles = this.getVehicleByCode();

		for(int i = 0; i < filteredVehicles.size(); i++) {
			var addrressYear = API + "/" + filteredVehicles.get(i).code();
			String response = handler.getData(addrressYear);

			VehicleModel model = converter.getObject(response, VehicleModel.class);
			models.add(model);
		}

		models.forEach(System.out::println);
	}

	/**
	 * Makes a request that returns a list of vehicle brand.
	 *
	 * @return List<VehicleBrand>
	 */
	private List<Brand> getVehicleType() {
		System.out.println("""
				Choose vehicle type you're searching for:\s
				1 - Car
				2 - Motorcycle
				3 - Truck""");
		int option = input.nextInt();
		String json = null;

		switch(option) {
			case 1 ->  json = handler.getData(API += "carros/marcas/");
			case 2 ->  json = handler.getData(API += "motos/marcas/");
			case 3 ->  json = handler.getData(API += "caminhoes/marcas/");
		}

		return converter.getObjectList(json, Brand.class);
	}

	/**
	 * Returns the vehicles by their brand
	 *
	 * @return List<Vehicle>
	 */
	private List<Vehicle> getVehiclesByBrand() {
		System.out.print("Type the code of the brand you're searching for: ");
		int code = input.nextInt();
		input.nextLine();

		API += code + "/modelos/";

		String json = handler.getData(API);
		return converter.getObject(json, VehicleList.class).getVehicles();
	}

	/**
	 * Get vehicles by their names
	 *
	 * @param vehicles List<Vehicle>
	 * @return List<Vehicle>
	 */
	private List<Vehicle> getVehicleByName(List<Vehicle> vehicles) {
		System.out.println("Type the car name you're searching for: ");
		String name = input.nextLine().toUpperCase();

		return vehicles.stream()
				.filter(v -> v.name().toUpperCase().contains(name))
				.collect(Collectors.toList());
	}

	/**
	 * return a list of car of the same code
	 *
	 * @return List<Vehicles>
	 */
	private List<Vehicle> getVehicleByCode() {
		System.out.println("Type the vehicle code you're searching for:");
		String code = input.nextLine();

		API += code + "/anos";
		String json = handler.getData(API);


		return converter.getObjectList(json, Vehicle.class);
	}
}
