package com.beanval1.service;

import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.beanval1.constraints.CarsAreOfSameModel;
import com.beanval1.model.Car;
import com.beanval1.model.Fish;

@RequestScoped
public class ExampleService {

	@Valid
	public Fish loadFish(	@NotNull String kind,
							@NotNull Integer weight) {
		Fish fish = new Fish();
		fish.setKind(kind);
		fish.setWeight(weight);
		return fish;
	}

	@CarsAreOfSameModel
	public void swapMotors(Car car1, Car car2) {
		// TODO Auto-generated method stub
		
	}

}
