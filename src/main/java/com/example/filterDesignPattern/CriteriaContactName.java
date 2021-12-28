package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.users.Contact;

public class CriteriaContactName implements ContactCriteria {

	private String criteriaVariable;
	public CriteriaContactName(String variable){
		this.criteriaVariable=variable;
	}
	
	@Override
	public ArrayList<Contact> meetCriteria(ArrayList<Contact> contacts) {
		ArrayList<Contact> filteredContacts=new ArrayList<Contact>();
		for(Contact contact:contacts) {
			if(contact.getContactName().contains(this.criteriaVariable))
				filteredContacts.add(contact);
		}
		return filteredContacts;
	}

}
