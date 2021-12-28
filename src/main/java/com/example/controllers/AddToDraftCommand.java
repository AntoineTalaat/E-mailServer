package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

public class AddToDraftCommand implements ICommand{
	private Mail mail;
	private MailDatabase database;
	
	
	public AddToDraftCommand(Mail mail) {
		this.mail=mail;
		this.database=new MailDatabase(this.mail.getFromEmail());
	}
	
	
	@Override
	public void execute() {
		ArrayList<Mail> draft=database.getDraftData();
		//can use cached 
		draft.add(this.mail);
		database.saveDraftData(draft);
	}

}
