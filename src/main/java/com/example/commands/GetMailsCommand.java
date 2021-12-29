package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.mail.Mail;

public class GetMailsCommand implements IMailCommand {
	private MailDatabase database;
	private String account;
	private String folder;
	
	
	public GetMailsCommand(String account,String folder){
		this.account=account;
		this.folder=folder;
		database=new MailDatabase(this.account);
	}
	
	@Override
	public ArrayList<Mail> execute() {
		ArrayList<Mail> mail;
		switch(this.folder) {
		case "inbox":
			mail=database.getInboxData();
			break;
		case "sent":
			mail=database.getSentData();
			break;
		case "trash":
			mail=database.getTrashData();
			break;
		case "draft":
			mail=database.getDraftData();
			break;
		default:
			//code to read custom json file
			mail=new ArrayList<Mail>();
			break;
		}
		
		return mail;
	}

}
