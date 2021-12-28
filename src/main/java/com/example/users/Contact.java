package com.example.users;

import java.util.ArrayList;

public class Contact {

	private String contactName;
	private ArrayList<String> contactAdresses;
	private int contactID;
	
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public ArrayList<String> getContactAdresses() {
		return contactAdresses;
	}
	public void setContactAdresses(ArrayList<String> contactAdresses) {
		this.contactAdresses = contactAdresses;
	}

}
