package com.example.users;

import java.util.ArrayList;
import java.util.Comparator;

import com.example.mail.Mail;

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
	
	
	
	public static Comparator<Contact> ContactNameComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			String contact1 = c1.getContactName().toUpperCase();
			String contact2 = c2.getContactName().toUpperCase();
			return contact1.compareTo(contact2);
		}
	};

}
