package com.example.controllers;

import com.example.users.Contact;

public class DeleteContactCommand {
	private String userName;
	private Contact contact; 
	private MailDatabase database;
	
	public DeleteContactCommand(String userName,Contact contact) {
		this.userName=userName;
		this.contact=contact;
		this.database=new MailDatabase(userName);
		}
	
	
}
