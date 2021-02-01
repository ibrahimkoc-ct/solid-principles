package com.ba.dependencyInversion.good;

public class ProductManager {
	
	private IProduction production;

	public ProductManager(IProduction production) {
		
		this.production = production;
	}

}
