package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

/*
 * Caching done here
 * to delete a mail we need to remove the mail with the id specified from the inbox of the caller
 */
public class DeleteMailCommand implements ICommand {
	private int deleteMessageID;
	private String collectionName;
	private String userName;
//	private UserCacheManager cache;

	
	public DeleteMailCommand(String userName,int messageID,String collection) {
		this.userName=userName;
		this.deleteMessageID=messageID;
		this.collectionName=collection;
//		this.cache=this.cache.getInstance();
	}

	@Override
	public void execute() {
		MailDatabase data = new MailDatabase(this.userName);
		
		ArrayList<Mail> collection;
		ArrayList<Mail> cachedCollection;

		ArrayList<Mail> trash=data.getTrashData();
		switch (this.collectionName) {
		case "inbox":
			collection=data.getInboxData();
			this.findAndDelete(collection,trash);
//			cachedCollection = cache.fetchUser(userName).getInboxMail();
//			this.findAndDelete(cachedCollection);
			data.saveInboxData(collection);
			break;
		case "sent":
			collection=data.getSentData();
			this.findAndDelete(collection);
//			cachedCollection = cache.fetchUser(userName).getSentMail();
//			this.findAndDelete(cachedCollection);
			data.saveSentData(collection);
			break;
		case "trash":
			collection=data.getTrashData();
			this.findAndDelete(collection);
//			cachedCollection = cache.fetchUser(userName).getTrashMail();
//			this.findAndDelete(cachedCollection);
			data.saveTrashData(collection);
			break;
		case "draft":
			collection=data.getDraftData();
			this.findAndDelete(collection);
//			cachedCollection = cache.fetchUser(userName).getDraftMail();
//			this.findAndDelete(cachedCollection);
			data.saveDraftData(collection);
			break;
		default:
			break;
		}
		data.saveTrashData(trash);
		
	}
	
	
	private void findAndDelete(ArrayList<Mail> collection){
		
		for(int i=0;i<collection.size();i++) {
			if(collection.get(i).getId()==this.deleteMessageID) {
				collection.remove(i);
				break;
			}
		}
		
	}
	
	private void findAndDelete(ArrayList<Mail> collection,ArrayList<Mail> trash){
			
			for(int i=0;i<collection.size();i++) {
				if(collection.get(i).getId()==this.deleteMessageID) {
					trash.add(collection.get(i));
					collection.remove(i);
					break;
				}
			}
			
		}
	
	
	
	
}
