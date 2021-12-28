package com.example.controllers;

import java.util.ArrayList;

import com.example.filterDesignPattern.CriteriaMailSearch;
import com.example.filterDesignPattern.MailCriteria;
import com.example.mail.Mail;

public class SearchByWordCommand implements IMailCommand {
	private ArrayList<Mail> collection;
	private String searchWord;
	private MailDatabase database;
	private String folder;
	
	public SearchByWordCommand(String userName,String folder, String searchWord) {
		this.folder=folder;
		this.database=new MailDatabase(userName);
		this.searchWord=searchWord;
		switch(this.folder) {
		case "inbox":
			this.collection=database.getInboxData();
//			this.mail=cache.fetchUser(this.account).getInboxMail();
			break;
		case "sent":
			this.collection=database.getSentData();
//			this.mail=cache.fetchUser(this.account).getSentMail();
			break;
		case "trash":
			this.collection=database.getTrashData();
//			this.mail=cache.fetchUser(this.account).getTrashMail();
			break;
		case "draft":
			this.collection=database.getDraftData();
//			this.mail=cache.fetchUser(this.account).getDraftMail();
			break;
		
		default:
			//code to read custom json file
			this.collection=new ArrayList<Mail>();
			break;
		}
	}
	
	
	@Override
	public ArrayList<Mail> execute() {
		MailCriteria searchProcess=new CriteriaMailSearch(this.searchWord);
		return searchProcess.meetCriteria(this.collection);
	}

}
