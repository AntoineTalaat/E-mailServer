package com.example.users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.example.fileManagement.UserFileCreator;
import com.example.mail.Mail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserBuilder {
	private UserFileCreator fileCreator;
	private Gson gson=new Gson();
	
	public UserBuilder() {
		fileCreator = new UserFileCreator();
	}
	
	
	private void buildEmptyContacts(User x) throws IOException {
		String targetPath="./accounts/"+x.getName()+"/contacts.JSON";
		File contactsFile = new File(targetPath);
		contactsFile.createNewFile();
		this.setupEmptyMailList(targetPath);
	}
	
	private void buildEmptyInbox(User x) throws IOException {
		String targetPath="./accounts/"+x.getName()+"/inbox.JSON";
		File inboxFile =  new File(targetPath);
		inboxFile.createNewFile();
		this.setupEmptyMailList(targetPath);
	}
	
	private void buildEmptyTrash(User x) throws IOException {
		String targetPath="./accounts/"+x.getName()+"/trash.JSON";
		File trashFile =  new File(targetPath);
		trashFile.createNewFile();
		this.setupEmptyMailList(targetPath);
	}
	
	private void buildEmptySent(User x) throws IOException {
		String targetPath="./accounts/"+x.getName()+"/sent.JSON";
		File sentFile = new File(targetPath);
		sentFile.createNewFile();
		this.setupEmptyMailList(targetPath);
	}
	
	private void buildEmptyDraft(User x) throws IOException {
		String targetPath="./accounts/"+x.getName()+"/draft.JSON";
		File draftFile = new File(targetPath);
		draftFile.createNewFile();
		this.setupEmptyMailList(targetPath);
	}
	
	
	private void setupEmptyMailList(String filepath) {
		ArrayList<Mail> emptyMail=new ArrayList<Mail>();
		Type listType = new TypeToken<ArrayList<Mail>>() {}.getType();
		String jsontxt = this.gson.toJson(emptyMail, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(filepath);
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
