package com.example.controllers;

import java.util.ArrayList;

/***
 * this class will check two things 
 * 1/ the user logging in exists in the dataBase
 * 2/ the user is not already Logged in
 * @author Tony
 *
 */
public class LoginCommandProxy implements ICommandProxy{
	private String userName;
	private UserDatabase database;
	//private UserCacheManager cache;
	//a password can be passed to the constructor
	public LoginCommandProxy(String userName) {
	//	this.cache=this.cache.getInstance();
		this.database=new UserDatabase();
		this.userName=userName;
	}
	
	
	@Override
	public boolean execute() {
		boolean successful = true;
		ArrayList<String> users =database.getUserListFromFile();
		if(users.contains(userName)==false) successful=false;
		//if(cache.isFetched(userName)) successful=false;
		
		if(successful) {
			ICommand command = new LoginCommand(userName);
			command.execute();
		}
		
		return successful;
	}
	
}
