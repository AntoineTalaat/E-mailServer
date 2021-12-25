package com.example.mail;

import java.util.*;

public class Mail {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String ID;
	private String date;
	private int priority;
	private ArrayList<String> attachements;
	private String body;
	
	
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public ArrayList<String> getAttachements() {
		return attachements;
	}
	public void setAttachements(ArrayList<String> attachements) {
		this.attachements = attachements;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
	
}
