package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;
import com.example.mail.filterObject;

public class CriteriaMailFilter implements MailCriteria {
	filterObject criterias;
	MailCriteria testCriteria;
	
	public CriteriaMailFilter(filterObject object) {
	      this.criterias=object;
	   }
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> toBeFilteredMail) {
	      ArrayList<Mail> mails = toBeFilteredMail;
	      if(!this.criterias.getSubject().equals("")) {
	    	  this.testCriteria= new CriteriaSubject(this.criterias.getSubject());
	    	  mails=this.testCriteria.meetCriteria(mails);
	    	  }
	      if(!this.criterias.getSender().equals("")) {
	    	  this.testCriteria= new CriteriaSender(this.criterias.getSender());
	    	  mails=this.testCriteria.meetCriteria(mails);
	    	  }
	      if(!this.criterias.getReceiver().equals("")) {
	    	  this.testCriteria= new CriteriaReceiver(this.criterias.getReceiver());
	    	  mails=this.testCriteria.meetCriteria(mails);
	    	  }
	      if(!this.criterias.getDate().equals("")) {
	    	  this.testCriteria= new CriteriaDate(this.criterias.getDate());
	    	  mails=this.testCriteria.meetCriteria(mails);
	    	  }
	      if(this.criterias.getPriority()!=0) {
	    	  this.testCriteria= new CriteriaPriority(this.criterias.getPriority());
	    	  mails=this.testCriteria.meetCriteria(mails);
	    	  }
	      return mails;
	   }
}
