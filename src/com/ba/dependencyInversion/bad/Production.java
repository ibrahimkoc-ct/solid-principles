package com.ba.dependencyInversion.bad;

public class Production {
	
	public void production() {
		Car car = new Car();
		car.assemble();
	}
}
