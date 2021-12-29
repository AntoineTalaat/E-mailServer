package com.example.commands;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.example.mail.Mail;

public class PrioritySorter{
	public static ArrayList<Mail> sort(ArrayList<Mail> collection) {
		PriorityQueue<Mail> q=new PriorityQueue<Mail>(collection.size(),Mail.PriorityComparator);
		for(int i=0;i<collection.size();i++) {
			q.add(collection.get(i));
		}
		
		ArrayList<Mail> sortedMail = new ArrayList<Mail>();
		for(int i=0;i<collection.size();i++)
		{
			if(q.peek()!=null)
			sortedMail.add(q.poll());
		}
		return sortedMail;
	}
	
}
