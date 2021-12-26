package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

public interface ISortingCriteria {
	public ArrayList<Mail> sort(ArrayList<Mail> collection);
}
