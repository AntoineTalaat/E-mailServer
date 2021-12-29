package com.example.commands;

import java.util.ArrayList;

import com.example.fileManagement.UserDatabase;
import com.example.mail.Mail;

public class CreateMailCommandProxy implements ICommandProxy{
	 
			private String toUser;
			private Mail mail;
			private UserDatabase database;

			
			public CreateMailCommandProxy(Mail mail) {
				this.toUser=mail.getToEmail();
				this.mail=mail;
				this.database = new UserDatabase();
			}
			
			
			public boolean execute() {
				boolean successful = true;
				ArrayList<String> users;
				users=this.database.getUserListFromFile();
				
				/**
				 * since the from name is guarenteed to be true 
				 * we need to check the to name to see if it is available
				 */
				if(!users.contains(this.toUser))
				{
					successful=false;
				}else {
					ICommand command = new CreateMailCommand(this.mail);
					command.execute();
				}
				return successful;
			}
}
