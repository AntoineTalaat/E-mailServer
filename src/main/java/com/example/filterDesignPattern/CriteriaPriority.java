package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaPriority implements MailCriteria {

	private int criteriaVariable;
	public CriteriaPriority(int variable){
		this.criteriaVariable=variable;
	}
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails) {
		ArrayList<Mail> filteredMail=new ArrayList<Mail>();
		for(Mail mail:mails) {
			if(mail.getPriority()==this.criteriaVariable)
				filteredMail.add(mail);
		}
		return filteredMail;
	}
}
