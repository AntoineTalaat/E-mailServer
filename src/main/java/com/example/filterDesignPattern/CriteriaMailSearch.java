package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public class CriteriaMailSearch implements MailCriteria {
	private String searchWord;
	
	public CriteriaMailSearch(String word) {
		this.searchWord=word;
	}
	
	
	@Override
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails) {
		MailCriteria subject=new CriteriaSubject(this.searchWord);
		MailCriteria sender=new CriteriaSender(this.searchWord);
		MailCriteria body=new CriteriaBody(this.searchWord);
		MailCriteria receiver=new CriteriaReceiver(this.searchWord);
		
		MailCriteria senderORreceiver= new CriteriaOr(sender,receiver);
		MailCriteria subjectORbody=new CriteriaOr(subject,body);
		
		MailCriteria allPossibilities = new CriteriaOr(senderORreceiver,subjectORbody);
		
		ArrayList<Mail> searchResults = allPossibilities.meetCriteria(mails);
		return searchResults;
	}

}
