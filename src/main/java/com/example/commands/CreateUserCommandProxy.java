package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.UserDatabase;

public class CreateUserCommandProxy implements ICommandProxy {
	private String userName;
	private UserDatabase database;
	
	public CreateUserCommandProxy(String name){
		this.userName=name;
		database = new UserDatabase();
	}
	
	public boolean execute() {
		boolean successful=true;
		
		ArrayList<String> users;
		users=this.database.getUserListFromFile();
		if(users.contains(this.userName)) {
			successful=false;
		}else {
			ICommand command = new CreateUserCommand(this.userName);
			command.execute();
		}
		return successful;
		
		

	}
}
