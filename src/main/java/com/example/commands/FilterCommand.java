package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.filterDesignPattern.CriteriaMailFilter;
import com.example.filterDesignPattern.MailCriteria;
import com.example.mail.Mail;

public class FilterCommand implements IMailCommand{
	private ArrayList<Mail> collection;
	private MailDatabase database;
	private String folder;
	private filterObject filters;
	
	public FilterCommand(String userName,String folder,filterObject filters) {
		this.filters=filters;
		this.folder=folder;
		this.database=new MailDatabase(userName);
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
		MailCriteria filterProcess = new CriteriaMailFilter(this.filters);
		return filterProcess.meetCriteria(this.collection);
	}

}
