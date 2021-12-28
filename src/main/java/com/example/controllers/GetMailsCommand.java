package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

public class GetMailsCommand implements IMailCommand {
	private MailDatabase database;
	//private UserCacheManager cache;
	private String account;
	private String folder;
	
	
	public GetMailsCommand(String account,String folder){
		this.account=account;
		this.folder=folder;
		database=new MailDatabase(this.account);
	//	this.cache=this.cache.getInstance();
	}
	
	@Override
	public ArrayList<Mail> execute() {
		ArrayList<Mail> mail;
		switch(this.folder) {
		case "inbox":
			mail=database.getInboxData();
//			mail=cache.fetchUser(this.account).getInboxMail();
			break;
		case "sent":
			mail=database.getSentData();
//			mail=cache.fetchUser(this.account).getSentMail();
			break;
		case "trash":
			mail=database.getTrashData();
//			mail=cache.fetchUser(this.account).getTrashMail();
			break;
		case "draft":
			mail=database.getDraftData();
//			mail=cache.fetchUser(this.account).getDraftMail();
			break;
		default:
			//code to read custom json file
			mail=new ArrayList<Mail>();
			break;
		}
		
		return mail;
	}

}
