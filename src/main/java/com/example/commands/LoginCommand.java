package com.example.commands;

import com.example.fileManagement.MailDatabase;
import com.example.users.User;

public class LoginCommand implements ICommand{
	//private UserCacheManager cache;
	private MailDatabase mailData;
	private User user;
	
	public LoginCommand(String userName) {
		//this.cache=cache.getInstance();
		//we fetch the user data and store it to the cache
		User user = new User();
		user.setName(userName);
		this.mailData=new MailDatabase(userName);
		user.setSentMail(this.mailData.getSentData());
		user.setInboxMail(this.mailData.getInboxData());
		user.setDraftMail(this.mailData.getDraftData());
		user.setTrashMail(this.mailData.getTrashData());
		user.setContacts(this.mailData.getContactsData());
		this.user=user;
	}
	
	@Override
	public void execute() {
		//this.cache.addUser(this.user);
	}	
}
