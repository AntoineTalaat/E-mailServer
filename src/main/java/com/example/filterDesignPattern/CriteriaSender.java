package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaSender implements MailCriteria {
	private String criteriaVariable;
	public CriteriaSender(String variable){
		this.criteriaVariable=variable;
	}
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails) {
		ArrayList<Mail> filteredMail=new ArrayList<Mail>();
		for(Mail mail:mails) {
			if(mail.getFromEmail().contains(this.criteriaVariable))
				filteredMail.add(mail);
		}
		return filteredMail;
	}
}
