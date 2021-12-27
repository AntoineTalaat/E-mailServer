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
		// TODO Auto-generated method stub
		return null;
	}

	
}
