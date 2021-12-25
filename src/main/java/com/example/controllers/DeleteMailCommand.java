package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

/*
 * to delete a mail we need to remove the mail with the id specified from the inbox of the caller
 */
public class DeleteMailCommand implements ICommand {
	private int deleteMessageID;
	private String collectionName;
	private String userName;
	
	public DeleteMailCommand(String userName,int messageID,String collection) {
		this.userName=userName;
		this.deleteMessageID=messageID;
		this.collectionName=collection;
	}

	@Override
	public void execute() {
		MailDatabase data = new MailDatabase(this.userName);
		
		ArrayList<Mail> collection;
		switch (this.collectionName) {
		case "inbox":
			collection=data.getInboxData();
			this.findAndDelete(collection);
			data.saveInboxData(collection);
			break;
		case "sent":
			collection=data.getSentData();
			this.findAndDelete(collection);
			data.saveSentData(collection);
			break;
		case "trash":
			collection=data.getTrashData();
			this.findAndDelete(collection);
			data.saveTrashData(collection);
			break;
		case "draft":
			collection=data.getDraftData();
			this.findAndDelete(collection);
			data.saveDraftData(collection);
			break;
		default:
			break;
		}
		
	}
	
	
	private void findAndDelete(ArrayList<Mail> collection){
		
		for(int i=0;i<collection.size();i++) {
			if(collection.get(i).getID()==this.deleteMessageID) {
				collection.remove(i);
				break;
			}
		}
		
	}
	
	
	
	
}
