package com.example.mail;

import java.util.*;

public class Mail {
	private String sender;
	private String reciever;
	private String subject;
	private int ID;
	private String date;
	private int priority;
	private String attachement;
	private String body;

	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getFromEmail() {
		return sender;
	}

	public void setFromEmail(String fromEmail) {
		this.sender = fromEmail;
	}

	public String getToEmail() {
		return reciever;
	}

	public void setToEmail(String toEmail) {
		this.reciever = toEmail;
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

	public String getAttachement() {
		return attachement;
	}

	public void setAttachement(String attachements) {
		this.attachement = attachements;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/*
	 * the comparators sets the arrangement ascending
	 */
	public static Comparator<Mail> MailSubjectComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
			String subject1 = m1.getSubject().toUpperCase();
			String subject2 = m2.getSubject().toUpperCase();
			return subject1.compareTo(subject2);
		}
	};

	public static Comparator<Mail> MailBodyComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
			String body1 = m1.getBody().toUpperCase();
			String body2 = m2.getBody().toUpperCase();
			return body1.compareTo(body2);
		}
	};

	
	/*
	 * Only date sets the comparing descending
	 */
	public static Comparator<Mail> MailDateComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
			String date1 = m1.getDate().toUpperCase();
			String date2 = m2.getDate().toUpperCase();
			return date2.compareTo(date1);
		}
	};

	
	
	public static Comparator<Mail> MailSenderComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
		   String sender1 = m1.getFromEmail().toUpperCase();
		   String sender2 = m2.getFromEmail().toUpperCase();
		   return sender1.compareTo(sender2); 
		   // sender1-sender2
		   // +ve >> sender1>sender2
		   // -ve >> sender1<sender2
	    }};
	    
	    //Descending order
    public static Comparator<Mail> PriorityComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
			int priority1 = m1.getPriority();
			int priority2 = m2.getPriority();
			return priority2-priority1;
		}
	};
	
	
	public static Comparator<Mail> MailReceiverComparator = new Comparator<Mail>() {
		public int compare(Mail m1, Mail m2) {
		String receiver1 = m1.getToEmail().toUpperCase();
		String receiver2 = m2.getToEmail().toUpperCase();
		return receiver1.compareTo(receiver2); 
		}
	};
}
