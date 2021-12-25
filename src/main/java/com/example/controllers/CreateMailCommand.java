package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;


/**
 * this class is responsible for delivering a previously created mail Object
 * to the folders of the senders and the receivers
 * @author Tony
 *
 */
public class CreateMailCommand implements ICommand {
	private String fromUser;
	private String toUser;
	private Mail mail;
	
	public CreateMailCommand(Mail mail) {
		this.fromUser=mail.getFromEmail();
		this.toUser=mail.getToEmail();
		this.mail=mail;
	}
	
	
	public void execute() {
		MailDatabase senderData = new MailDatabase(this.fromUser);
		MailDatabase receiverData = new MailDatabase(this.toUser);
		
		//get inbox of the user from json to arraylist
		ArrayList<Mail> inbox;
		inbox = receiverData.getInboxData();
		//add message 
		inbox.add(this.mail);
		//save inbox again
		receiverData.saveInboxData(inbox);
		
		
		//get sent of the other from json to arraylist
		ArrayList<Mail> sent;
		sent = senderData.getSentData();
		//add message 
		sent.add(this.mail);
		//save sent
		senderData.saveSentData(sent);
	}
}
