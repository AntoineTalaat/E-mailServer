package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaOr implements MailCriteria {
	private MailCriteria firstCriteria;
	private MailCriteria secondCriteria;
	
	public CriteriaOr(MailCriteria criteria, MailCriteria otherCriteria) {
	      this.firstCriteria = criteria;
	      this.secondCriteria = otherCriteria; 
	   }
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> toBeFilteredMail) {
			System.out.println("size of mail entering or Criteria " +toBeFilteredMail.size() );
	      ArrayList<Mail> firstCriteriaMails = this.firstCriteria.meetCriteria(toBeFilteredMail);
	      ArrayList<Mail> secondCriteriaMails = this.secondCriteria.meetCriteria(toBeFilteredMail);

	      for (Mail mail : secondCriteriaMails) {
	         if(!firstCriteriaMails.contains(mail)){
	            firstCriteriaMails.add(mail);
	         }
	      }	
	      return firstCriteriaMails;
	   }

}
