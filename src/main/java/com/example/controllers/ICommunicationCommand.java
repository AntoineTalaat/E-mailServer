package com.example.controllers;

import java.util.ArrayList;

import com.example.mail.Mail;

public interface ICommunicationCommand {
	public ArrayList<Mail> execute();
}
