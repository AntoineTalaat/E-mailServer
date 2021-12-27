package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.users.Contact;

public interface ContactCriteria {
	public ArrayList<Contact> meetCriteria(ArrayList<Contact> mails);
}
