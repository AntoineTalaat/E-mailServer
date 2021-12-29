package com.example.mail;

import java.util.*;

public class Mail {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private int id;
	private String date;
	private int priority;

	public ArrayList<String> getAttachement() {
		return attachement;
	}

	public void setAttachement(ArrayList<String> attachement) {
		this.attachement = attachement;
	}

	private ArrayList<String> attachement;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
