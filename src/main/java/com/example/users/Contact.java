package com.example.users;

public class Contact {
	private String chosenName;
	private String firstAccountName;
	private String secondAccountName;
	
	public Contact(String chosenName,String lonelyAccountName)
	{
		this.chosenName=chosenName;
		this.firstAccountName=lonelyAccountName;
	}
	
	public Contact(String chosenName,String firstAccountName,String secondAccountName) {
		this.chosenName=chosenName;
		this.firstAccountName=firstAccountName;
		this.secondAccountName=secondAccountName;
	}
	
	public String[] getEmails() {
		String[] emails;
		if(this.secondAccountName==null) {
			emails= new String[1];
			emails[0]=firstAccountName;
		}else {
			emails=new String[2];
			emails[0]=firstAccountName;
			emails[1]=secondAccountName;
		}
		return emails;
	}
}
