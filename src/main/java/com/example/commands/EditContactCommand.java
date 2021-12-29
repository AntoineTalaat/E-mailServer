package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.users.Contact;

public class EditContactCommand implements ICommand {
	private int editContactID;
	private String userName;
	private MailDatabase database;
	private String newName;
	public EditContactCommand(String userName,int contactID,String newName) {
		this.userName=userName;
		this.editContactID=contactID;
		this.newName=newName;
		this.database=new MailDatabase(userName);
	}
	
	@Override
	public void execute() {
		ArrayList<Contact> contacts = database.getContactsData();
		findAndEdit(contacts);
		database.saveContactsData(contacts);
	}

	
	private void findAndEdit(ArrayList<Contact> collection){
		
		for(int i=0;i<collection.size();i++) {
			if(collection.get(i).getContactID()==this.editContactID) {
				collection.get(i).setContactName(newName);
				break;
			}
		}
		
	}
}
