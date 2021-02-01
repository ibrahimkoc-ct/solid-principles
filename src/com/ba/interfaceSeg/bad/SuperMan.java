package com.ba.interfaceSeg.bad;

public class SuperMan implements ISuperHero {

	@Override
	public String Costume() {
		return "My Costume is red and blue";

	}

	@Override
	public String Power() {
		return "I am from Krypton. Is that enough? ";
	}

	@Override
	public String BatMobile() {
		return "I can not use BatMobile";
	}

	@Override
	public String Fly() {
		return "I can fly";
	}

}
