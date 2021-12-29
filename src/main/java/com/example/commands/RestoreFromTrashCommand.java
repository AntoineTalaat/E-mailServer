 package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.MailDatabase;
import com.example.mail.Mail;

public class RestoreFromTrashCommand implements ICommand {
	private Mail mail;
	private String userName;
	private int mailID;
	private MailDatabase database;
	
	public RestoreFromTrashCommand(String userName ,int mailID) {
		this.userName=userName;
		this.mailID=mailID;
		this.database=new MailDatabase(userName);
	}
	
	@Override
	public void execute() {
		ArrayList<Mail> trash = database.getTrashData();
		this.findAndRestore(trash);
		database.saveTrashData(trash);
	}

	
	
private void findAndRestore(ArrayList<Mail> trash){
		for(int i=0;i<trash.size();i++) {
			if(trash.get(i).getId()==this.mailID) {
				this.mail=trash.get(i);
				trash.remove(i);
				if(this.mail.getFromEmail().equals(this.userName)) {
					//user is the sender
					//restore to sent files
					ArrayList<Mail> sent = database.getSentData();
					sent.add(mail);
					this.database.saveSentData(sent);
				}else if(this.mail.getToEmail().equals(this.userName)) {
					//user is the receiver
					//restore to inbox
					ArrayList<Mail> inbox = database.getInboxData();
					inbox.add(this.mail);
					this.database.saveInboxData(inbox);	
				}
				break;
			}
		}
		
	}
}
