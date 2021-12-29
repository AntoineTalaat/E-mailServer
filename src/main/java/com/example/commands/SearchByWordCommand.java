package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
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
			break;
		case "sent":
			this.collection=database.getSentData();
			break;
		case "trash":
			this.collection=database.getTrashData();
			break;
		case "draft":
			this.collection=database.getDraftData();
			break;
		
		default:
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
