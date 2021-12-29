package com.example.commands;

import java.util.ArrayList;

import com.example.mail.Mail;

public interface IMailCommand {
	public ArrayList<Mail> execute();
}
