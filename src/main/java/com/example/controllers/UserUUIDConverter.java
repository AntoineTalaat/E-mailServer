package com.example.controllers;
import java.util.*;
public class UserUUIDConverter {
	private Hashtable<String,String> map;
	
	public UserUUIDConverter() {
		map=new Hashtable<String,String>();
	}
	
	public String convertToUUID(String account) {
		UUID uuid=UUID.randomUUID(); //Generates random UUID
		int counter=0;
		while(this.map.contains(uuid)&&counter<1000) {
			uuid=UUID.randomUUID();
		}
		this.map.put(uuid.toString(), account);
		return uuid.toString();
	}
	
	public String convertToAccount(String uuid) {
		return this.map.get(uuid);
	}
	
	
	public void removeIdMapping(String uuid) {
		this.map.remove(uuid);
	}
	
	
	
	
	
}
