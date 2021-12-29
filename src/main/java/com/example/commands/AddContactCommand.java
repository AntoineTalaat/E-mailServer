package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.users.Contact;

public class AddContactCommand implements ICommand {
	private Contact contact; 
	private MailDatabase database;
	
	public AddContactCommand(String userName,Contact contact) {
		this.contact=contact;
		this.database=new MailDatabase(userName);
		}

	@Override
	public void execute() {
		ArrayList<Contact> allContacts=this.database.getContactsData();
		allContacts.add(this.contact);
		this.database.saveContactsData(allContacts);
	}
	
	
}
