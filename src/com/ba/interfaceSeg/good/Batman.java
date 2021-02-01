package com.ba.interfaceSeg.good;

public class Batman implements IBatMobile,ISuperHero{

	@Override
	public String UseBatMobile() {
    return "I can use BatMobile";

	}

	@Override
	public String Costume() {
		 return "My power is my money :D ";
	}

	@Override
	public String Power() {
        return "My Costume is dark";

	}
}
