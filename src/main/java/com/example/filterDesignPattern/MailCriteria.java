package com.example.filterDesignPattern;

import java.util.ArrayList;

import com.example.mail.Mail;

public interface MailCriteria {
	public ArrayList<Mail> meetCriteria(ArrayList<Mail> mails);
}
