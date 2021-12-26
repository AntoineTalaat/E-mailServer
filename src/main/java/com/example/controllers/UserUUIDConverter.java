package com.example.controllers;
import java.util.*;
public class UserUUIDConverter {
	private Hashtable<String,String> map;
	
	public UserUUIDConverter() {
		map=new Hashtable<String,String>();
	}
	
	public String convertToUUID(String account) {
		UUID uuid=UUID.randomUUID(); //Generates random UUID  
		while(this.map.contains(uuid)) {
			uuid=UUID.randomUUID();
		}
		this.map.put(uuid.toString(), account);
		return uuid.toString();
	}
	
	public String convertToAccount(String uuid) {
		return this.map.get(uuid);
	}
	
	
	
	
	
	
	
}
