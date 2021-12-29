package com.example.commands;

import java.util.ArrayList;
import java.util.Collections;

import com.example.fileManagement.MailDatabase;
import com.example.mail.Mail;

public class SortMailFolderCommand implements IMailCommand {
	private String folder;
	private String criteria;
	private MailDatabase database; 
	private ArrayList<Mail> mail;
	
	public SortMailFolderCommand(String userName,String folder,String criteria) {
		this.criteria=criteria;
		this.folder=folder;
		this.database=new MailDatabase(userName);
		switch(this.folder) {
		case "inbox":
			this.mail=database.getInboxData();
			break;
		case "sent":
			this.mail=database.getSentData();
			break;
		case "trash":
			this.mail=database.getTrashData();
			break;
		case "draft":
			this.mail=database.getDraftData();
			break;
		
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
			case "receiver":
				Collections.sort(this.mail,Mail.MailReceiverComparator);
				break;
			case "priority":
				this.mail=PrioritySorter.sort(this.mail);
				break;
			default:
				break;
		}
		return this.mail;
	}
}
