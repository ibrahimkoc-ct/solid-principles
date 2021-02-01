package com.ba.openClosed.good;

public class Logger {
	private ILogger logger;
	
	public void Log(String value) {
		logger.Log(value);
	}
}
