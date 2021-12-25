package com.example.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.users.SecurityInfo;
import com.example.users.User;
import com.example.users.UserBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class CreateUserCommand implements ICommand{
	private String userName;
	private UserDatabase database;
	
	public CreateUserCommand(String name) {
		this.userName=name;
		database = new UserDatabase();
	}
	
	public void execute() {
		UserBuilder builder=new UserBuilder();
		User x = builder.getUser(this.userName);
		
		ArrayList<String> users;
		users=this.database.getUserListFromFile();
		users.add(this.userName);		
		this.database.saveUserListToFile(users);
	}
}
