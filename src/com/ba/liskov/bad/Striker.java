package com.ba.liskov.bad;

public class Striker extends Player{

	@Override
	public String kickTheBall() {
		return super.kickTheBall();
	}
	
}
