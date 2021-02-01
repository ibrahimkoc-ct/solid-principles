package com.ba.dependencyInversion.good;

public class Car implements IProduction{

	@Override
	public boolean assemble() {
		return true;
	}
}
