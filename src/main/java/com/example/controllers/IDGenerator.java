package com.example.controllers;

public class IDGenerator {
	private static int id=0;
	private String folderPath = "./accounts/";
	
	
	
	public static int getID() {
		return (id++);
	}
}
