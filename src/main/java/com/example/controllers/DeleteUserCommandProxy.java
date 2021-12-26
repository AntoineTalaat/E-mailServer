package com.example.controllers;

import java.util.ArrayList;

public class DeleteUserCommandProxy implements ICommandProxy{
	private String userName;
	private UserDatabase database;
	
	public DeleteUserCommandProxy(String name){
		this.userName=name;
		database = new UserDatabase();
	}
	
	public boolean execute() {
		boolean successful=true;
		
		ArrayList<String> users;
		users=this.database.getUserListFromFile();
		if(!users.contains(this.userName)) {
			successful=false;
		}else {
			ICommand command = new DeleteUserCommand(this.userName);
			command.execute();
		}
		return successful;
	}
}
