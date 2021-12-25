package com.example.users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.example.fileManagement.UserFileCreator;
import com.google.gson.Gson;

public class UserBuilder {
	private UserFileCreator fileCreator;
	
	
	public UserBuilder() {
		fileCreator = new UserFileCreator();
	}
	
	
	private void buildEmptyContacts(User x) throws IOException {
		File contactsFile = new File("./accounts/"+x.getName()+"/contacts.JSON");
		contactsFile.createNewFile();
	}
	
	private void buildEmptyInbox(User x) throws IOException {
		File inboxFile = new File("./accounts/"+x.getName()+"/inbox.JSON");
		inboxFile.createNewFile();
	}
	
	private void buildEmptyTrash(User x) throws IOException {
		File trashFile = new File("./accounts/"+x.getName()+"/trash.JSON");
		trashFile.createNewFile();
	}
	
	private void buildEmptySent(User x) throws IOException {
		File sentFile = new File("./accounts/"+x.getName()+"/sent.JSON");
		sentFile.createNewFile();
	}
	
	private void buildEmptyDraft(User x) throws IOException {
		File draftFile = new File("./accounts/"+x.getName()+"/draft.JSON");
		draftFile.createNewFile();
	}
	
	
	
	public User getUser(String name) {
		User x = new User();
		x.setName(name);
		fileCreator.create(x.getName());
		try {
			this.buildEmptyContacts(x);
			this.buildEmptyInbox(x);
			this.buildEmptySent(x);
			this.buildEmptyTrash(x);
			this.buildEmptyDraft(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	
}
