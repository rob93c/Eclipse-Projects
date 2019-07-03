package com.yoox.patterns;

public class Application2 {

	public static void main(String[] args) {
		
		HelloSingle hs = HelloSingle.getInstance();
		HelloSingle hs2 = HelloSingle.getInstance();
		
		System.out.println(hs == hs2);
	}

}
