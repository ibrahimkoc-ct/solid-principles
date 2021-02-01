package com.ba.liskov.bad;

public class Goalkeeper extends Player{

	@Override
	public String kickTheBall() {
		return super.kickTheBall();
	}

	@Override
	public String keepTheBall() {
		return super.keepTheBall();
	}
}
