package com.example.controllers;

import java.util.ArrayList;

public class CreateMailCommand implements ICommand {
	
	public void execute() {
		ArrayList<String> users;
		users=this.database.getUserListFromFile();
	}
}
