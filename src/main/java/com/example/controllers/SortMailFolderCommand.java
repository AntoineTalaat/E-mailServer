package com.example.controllers;

import java.util.ArrayList;
import java.util.Collections;

import com.example.mail.Mail;

public class SortMailFolderCommand implements ICommunicationCommand {
	private String userName;
	private String folder;
	private String criteria;
	private MailDatabase database; 
	private ArrayList<Mail> mail;
	
	public SortMailFolderCommand(String userName,String folder,String criteria) {
		this.userName=userName;
		this.criteria=criteria;
		this.folder=folder;
		this.database=new MailDatabase(userName);
		switch(this.folder) {
		case "inbox":
			this.mail=database.getInboxData();
//			this.mail=cache.fetchUser(this.account).getInboxMail();
			break;
		case "sent":
			this.mail=database.getSentData();
//			this.mail=cache.fetchUser(this.account).getSentMail();
			break;
		case "trash":
			this.mail=database.getTrashData();
//			this.mail=cache.fetchUser(this.account).getTrashMail();
			break;
		case "draft":
			this.mail=database.getDraftData();
//			this.mail=cache.fetchUser(this.account).getDraftMail();
			break;
		case "priority":
			thi
		default:
			//code to read custom json file
			this.mail=new ArrayList<Mail>();
			break;
		}
	}

	@Override
	public ArrayList<Mail> execute() {	
		switch(this.criteria) {
			case "subject":
				Collections.sort(this.mail, Mail.MailSubjectComparator);
				break;
			case "body":
				Collections.sort(this.mail, Mail.MailBodyComparator);
				break;
			case "date":
				Collections.sort(this.mail, Mail.MailDateComparator);
				break;
			case "sender":
				Collections.sort(this.mail, Mail.MailSenderComparator);
				break;
			default:
				break;
		}
		return this.mail;
	}
}
