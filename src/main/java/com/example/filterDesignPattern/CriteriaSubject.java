package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaSubject implements MailCriteria {
	private String criteriaVariable;
	
	
	public CriteriaSubject(String variable){
		this.criteriaVariable=variable;
	}
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails) {
		System.out.println("number of mails entering subject "+ mails.size());
		ArrayList<Mail> filteredMail=new ArrayList<Mail>();
		for(Mail mail:mails) {
			System.out.println("current mail subject "+ mail.getSubject());
			if(mail.getSubject().contains(this.criteriaVariable))
				filteredMail.add(mail);
		}
		System.out.println("number of mails matching subject "+ filteredMail.size());
		return filteredMail;
	}

}
