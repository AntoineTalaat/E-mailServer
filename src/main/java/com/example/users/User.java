package com.example.users;

import java.util.*;

import com.example.mail.Mail;

public class User {
	private String name;
	private HashMap<String,ArrayList<String>> contacts=null;
	private ArrayList<Mail> inboxMail=null;
	private ArrayList<Mail> sentMail=null;
	private ArrayList<Mail> trashMail=null;
	private ArrayList<Mail> draftMail=null;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, ArrayList<String>> getContacts() {
		return contacts;
	}
	public void setContacts(HashMap<String, ArrayList<String>> contacts) {
		this.contacts = contacts;
	}
	public ArrayList<Mail> getReceivedMail() {
		return inboxMail;
	}
	public void setReceivedMail(ArrayList<Mail> receivedMail) {
		this.inboxMail = receivedMail;
	}
	public ArrayList<Mail> getSentMail() {
		return sentMail;
	}
	public void setSentMail(ArrayList<Mail> sentMail) {
		this.sentMail = sentMail;
	}
	public ArrayList<Mail> getDraftMail() {
		return draftMail;
	}
	public void setDraftMail(ArrayList<Mail> draftMail) {
		this.draftMail = draftMail;
	}
	
	
	
}
