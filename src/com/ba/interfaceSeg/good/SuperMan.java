package com.ba.interfaceSeg.good;

public class SuperMan implements ISuperHero, IFly {

	@Override
	public String Costume() {
		return "My Costume is red and blue";

	}

	@Override
	public String Power() {
		return "I am from Krypton. Is that enough? ";

	}

	@Override
	public String FlyToSomeWhere() {
		return "I can fly";

	}
}
