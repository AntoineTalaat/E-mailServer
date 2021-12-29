package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.controllers.CreateMailCommand;
import com.example.controllers.CreateMailCommandProxy;
import com.example.controllers.CreateUserCommandProxy;
import com.example.controllers.DeleteMailCommand;
import com.example.controllers.DeleteUserCommandProxy;
import com.example.controllers.ICommand;
import com.example.controllers.ICommandProxy;
import com.example.controllers.MailDatabase;
import com.example.controllers.RestoreFromTrashCommand;
import com.example.controllers.UserDatabase;
import com.example.mail.Mail;

@SpringBootTest
class EMailServerApplicationTests {

	@BeforeEach
	public void setup() {
		//clearDatabase
	}
	
	@Test
	void contextLoads() {	
	}

	@Test
	void createUser() {
		String newUserName="Ahmed@oop";
		ICommandProxy command = new CreateUserCommandProxy(newUserName);
		assertEquals(command.execute(),true,"Failed to create user in database");
		UserDatabase database = new UserDatabase();
		ArrayList<String> users = database.getUserListFromFile();
		assertEquals(users.contains(newUserName),true,"Can't find user name in database");
	}
	
	@Test
	void deleteUser() {
		String newUserName="Ahmed@oop";
		ICommandProxy command = new DeleteUserCommandProxy(newUserName);
		assertEquals(command.execute(),true,"Failed to find and delete user from database");
		UserDatabase database = new UserDatabase();
		ArrayList<String> users = database.getUserListFromFile();
		assertEquals(users.contains(newUserName),false,"Found user name in database");
	}
		
	@Test
	void sendMail() {
		String user1="user1@oop";
		String user2="user2@oop";
		ICommandProxy command1 = new CreateUserCommandProxy(user1);
		ICommandProxy command2 = new CreateUserCommandProxy(user2);
		assertEquals(command1.execute() && command2.execute(),true,"user creation failed");
		Mail mail = new Mail();
		mail.setFromEmail(user1);
		mail.setToEmail(user2);
		mail.setDate("2021-09-12");
		mail.setPriority(3);
		mail.setSubject("Trying this new mail website!");
		mail.setBody("Hello,user2 .. I am user 1 and I am testing this website .. please tell me if you recieved this message.");
		mail.setAttachement("");
		mail.setId(0);
		
		ICommandProxy commandSend = new CreateMailCommandProxy(mail);
		assertEquals(commandSend.execute(),true,"sending not successful");
		
		MailDatabase database=new MailDatabase(user2);
		ArrayList<Mail> inboxOfuser2 = database.getInboxData();
		assertEquals(inboxOfuser2.size()==1,true,"inbox size not expected");
		assertEquals(inboxOfuser2.get(0).getSubject().equals("Trying this new mail website!")
				,true,"mail is not recognized as given");
		ICommandProxy command1reverse = new DeleteUserCommandProxy(user1);
		ICommandProxy command2reverse = new DeleteUserCommandProxy(user2);
		assertEquals(command1reverse.execute(),true,"failed to delete first user");
		assertEquals(command2reverse.execute(),true,"failed to delete second user");
	}
	
	@Test
	void createMailAndSendMessageAndDeleteAndRestore() {
		String user1="user3@oop";
		String user2="user4@oop";
		ICommandProxy command1 = new CreateUserCommandProxy(user1);
		ICommandProxy command2 = new CreateUserCommandProxy(user2);
		assertEquals(command1.execute() && command2.execute(),true,"user creation failed");
		Mail mail = new Mail();
		mail.setFromEmail(user1);
		mail.setToEmail(user2);
		mail.setDate("2021-09-12");
		mail.setPriority(3);
		mail.setSubject("Trying this new mail website!");
		mail.setBody("Hello,user2 .. I am user 1 and I am testing this website .. please tell me if you recieved this message.");
		mail.setAttachement("");
		mail.setId(55);
		
		ICommandProxy commandSend = new CreateMailCommandProxy(mail);
		assertEquals(commandSend.execute(),true,"sending not successful");
		
		MailDatabase database1=new MailDatabase(user1);
		MailDatabase database2=new MailDatabase(user2);
		ArrayList<Mail> inboxOfuser2 = database2.getInboxData();
		assertEquals(inboxOfuser2.size()==1,true,"inbox size not expected");
		assertEquals(inboxOfuser2.get(0).getSubject().equals("Trying this new mail website!")
				,true,"mail is not recognized as given");
		
		ICommand deleteMailCommand= new DeleteMailCommand(user2,55,"inbox");
		deleteMailCommand.execute();
		
		inboxOfuser2=database2.getInboxData();
		assertEquals(inboxOfuser2.size()==0,true,"inbox size not expected after deletion");
		
		ArrayList<Mail> trashOfuser2= database2.getTrashData();
		assertEquals(trashOfuser2.size()==1,true,"trash size not expected ");
		assertEquals(trashOfuser2.get(0).getSubject().equals("Trying this new mail website!")
				,true,"mail is not recognized as given");
		
		ICommand restoreCommand = new RestoreFromTrashCommand(user2,55);
		restoreCommand.execute();
		inboxOfuser2=database2.getInboxData();
		trashOfuser2=database2.getTrashData();
		
		assertEquals(trashOfuser2.size()==0,true,"trash size not expected after restoring");
		assertEquals(inboxOfuser2.size()==1,true,"inbox size not expected after restoring");
		assertEquals(inboxOfuser2.get(0).getSubject().equals("Trying this new mail website!")
				,true,"mail is not recognized as given after restoring");
		
		
		
		ICommandProxy command1reverse = new DeleteUserCommandProxy(user1);
		ICommandProxy command2reverse = new DeleteUserCommandProxy(user2);
		assertEquals(command1reverse.execute(),true,"failed to delete first user");
		assertEquals(command2reverse.execute(),true,"failed to delete second user");
	}
	
	
	@Test
	void givingDiffentMailIDsToMails() {
		UserDatabase database=new UserDatabase();
		String user1="user3@oop";
		String user2="user4@oop";
		
		Mail mail1 = new Mail();
		mail1.setFromEmail(user1);
		mail1.setToEmail(user2);
		mail1.setDate("2021-09-12");
		mail1.setPriority(3);
		mail1.setSubject("Trying this new mail website!");
		mail1.setBody("Hello,user2 .. I am user 1 and I am testing this website .. please tell me if you recieved this message.");
		mail1.setAttachement("");
		int id=database.getID();
		mail1.setId(id);
		
		Mail mail2 = new Mail();
		mail2.setFromEmail(user1);
		mail2.setToEmail(user2);
		mail2.setDate("2021-09-12");
		mail2.setPriority(3);
		mail2.setSubject("Trying this new mail website!");
		mail2.setBody("Hello,user2 .. I am user 1 and I am testing this website .. please tell me if you recieved this message.");
		mail2.setAttachement("");
		id=database.getID();
		mail2.setId(id);
		
		assertEquals(mail1.getId()!=mail2.getId(),true,"The IDs are Identical!");
		
	}
	
	
	
	
	
	
}
