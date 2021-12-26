package com.example.controllers;

import java.io.File;
import java.util.ArrayList;

public class DeleteUserCommand implements ICommand {

	private UserCacheManager cache;
	private String userName;
	private UserDatabase database;
	
	public DeleteUserCommand(String name) {
		this.userName=name;
		database = new UserDatabase();
		this.cache=cache.getInstance();
	}
	
	
	
	@Override
	public void execute() {
		
		this.deleteFolder();	
		ArrayList<String> users;
		users=this.database.getUserListFromFile();
		users.remove(this.userName);
		cache.removeUser(userName);
		this.database.saveUserListToFile(users);
	}
	
	
	
	private void deleteFolder() {
		//Deleting Actual files
		String path = "./accounts/" + this.userName;
		this.deletefile(path+"/inbox.JSON");
		this.deletefile(path+"/contacts.JSON");
		this.deletefile(path+"/draft.JSON");
		this.deletefile(path+"/trash.JSON");
		this.deletefile(path+"/sent.JSON");
		this.deletefile(path);
	}
	
	
	
	
	private void deletefile(String path) {
		File myObj = new File(path); 
	    if (myObj.delete()) { 
	      System.out.println("Deleted the folder: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the folder.");
	    } 
	}
	
	
	
}
