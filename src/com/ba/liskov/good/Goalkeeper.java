package com.ba.liskov.good;

public class Goalkeeper extends Player implements IKeepTheBall{

	@Override
	public String kickTheBall() {
		return super.kickTheBall();
	}

	@Override
	public String keep() {
		return "keep the ball";
	}

}
