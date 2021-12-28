package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;
import com.example.users.Contact;

public class DeleteContactCommand implements ICommand{
	private String userName;
	private int deleteContactID ;
	private MailDatabase database;
	
	public DeleteContactCommand(String userName,int id) {
		this.userName=userName;
		this.deleteContactID=id;
		this.database=new MailDatabase(userName);
		}

	@Override
	public void execute() {
			ArrayList<Contact> contacts = database.getContactsData();
			this.findAndDelete(contacts);
			database.saveContactsData(contacts);
	}
	
	private void findAndDelete(ArrayList<Contact> collection){
		
		for(int i=0;i<collection.size();i++) {
			if(collection.get(i).getContactID()==this.deleteContactID) {
				collection.remove(i);
				break;
			}
		}
		
	}
}
