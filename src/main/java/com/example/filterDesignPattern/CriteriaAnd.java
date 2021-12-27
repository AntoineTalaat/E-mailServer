package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaAnd implements MailCriteria {

	private MailCriteria firstCriteria;
	private MailCriteria secondCriteria;
	
	public CriteriaAnd(MailCriteria criteria, MailCriteria otherCriteria) {
	      this.firstCriteria = criteria;
	      this.secondCriteria = otherCriteria; 
	   }
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> toBeFilteredMail) {
	      ArrayList<Mail> firstCriteriaMails = this.firstCriteria.meetCriteria(toBeFilteredMail);
	      return this.secondCriteria.meetCriteria(firstCriteriaMails);
	      
	   }
}
