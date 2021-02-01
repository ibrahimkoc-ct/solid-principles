package com.ba.openClosed.bad;

public class Logger {
	private XmlLog xmlLog;
	private DbLog dbLog;
	
	
	public void Log(LogType type,String value) {
		if(type==LogType.Xml) {
			xmlLog.Log(value);
		}
		else if(type==LogType.Db) {
			dbLog.Log(value);
		}
	}
}
