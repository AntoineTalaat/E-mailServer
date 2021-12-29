package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.users.Contact;

public class GetContactsCommand implements IContactCommand {
	private MailDatabase database;
	private String userName;
	public GetContactsCommand(String userName) {
		this.userName=userName;
		this.database=new MailDatabase(this.userName);
	}
	@Override
	public ArrayList<Contact> execute() {
		return this.database.getContactsData();
	}

}
