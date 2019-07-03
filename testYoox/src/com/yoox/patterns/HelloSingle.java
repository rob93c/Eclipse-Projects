package com.yoox.patterns;

public class HelloSingle {
	
	private static HelloSingle _instance;
	
	private HelloSingle() {
		System.out.println("Sono nel costruttore!");
	}
	
	public synchronized static HelloSingle getInstance() {
		if(_instance == null) {
			_instance = new HelloSingle();
		}
		return _instance;
	}
}
