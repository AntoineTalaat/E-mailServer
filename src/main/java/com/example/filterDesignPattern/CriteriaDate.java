package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.controllers.ISortingCriteria;
import com.example.mail.Mail;

public class CriteriaDate implements MailCriteria {
	private String criteriaVariable;
	public CriteriaDate(String variable){
		this.criteriaVariable=variable;
	}
	
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails) {
		ArrayList<Mail> filteredMail=new ArrayList<Mail>();
		for(Mail mail:mails) {
			if(mail.getDate().compareTo(criteriaVariable)<0)//-ve a>b +ve a<b
				filteredMail.add(mail);
		}
		return filteredMail;
	}


	
}
