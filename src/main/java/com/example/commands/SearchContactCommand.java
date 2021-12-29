package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.filterDesignPattern.ContactCriteria;
import com.example.filterDesignPattern.CriteriaContactName;
import com.example.mail.Mail;
import com.example.users.Contact;

public class SearchContactCommand implements IContactCommand {
	private ArrayList<Contact> collection;
	private String searchWord;
	private MailDatabase database;
	
	public SearchContactCommand(String userName, String searchWord) {
		this.database=new MailDatabase(userName);
		this.collection=database.getContactsData();
		this.searchWord=searchWord;
	}
	
	@Override
	public ArrayList<Contact> execute() {
		ContactCriteria search = new CriteriaContactName(searchWord);
		return search.meetCriteria(this.collection);
	}

}
