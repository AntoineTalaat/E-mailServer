package com.example.commands;

import java.util.ArrayList;
import java.util.Collections;

import com.example.fileManagement.MailDatabase;
import com.example.mail.Mail;
import com.example.users.Contact;

public class SortContactFolderCommand implements IContactCommand {

	private MailDatabase database; 
	private ArrayList<Contact> contacts;
	
	
	public SortContactFolderCommand(String userName) {
		this.database=new MailDatabase(userName);
	}
	
	
	@Override
	public ArrayList<Contact> execute() {
		this.contacts = database.getContactsData();
		Collections.sort(this.contacts,Contact.ContactNameComparator);
		return this.contacts;
	}

}
