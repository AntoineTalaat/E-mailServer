package com.example.users;

import java.util.*;

import com.example.mail.Mail;

public class User {
	private String name;
	private ArrayList<Contact> contacts=null;
	private ArrayList<Mail> inboxMail=null;
	private ArrayList<Mail> sentMail=null;
	private ArrayList<Mail> trashMail=null;
	private ArrayList<Mail> draftMail=null;
	
	
	public ArrayList<Mail> getInboxMail() {
		return inboxMail;
	}
	public void setInboxMail(ArrayList<Mail> inboxMail) {
		this.inboxMail = inboxMail;
	}
	public ArrayList<Mail> getTrashMail() {
		return trashMail;
	}
	public void setTrashMail(ArrayList<Mail> trashMail) {
		this.trashMail = trashMail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
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
