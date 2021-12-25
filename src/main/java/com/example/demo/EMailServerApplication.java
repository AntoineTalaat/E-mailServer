package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.CreateMailCommand;
import com.example.controllers.CreateMailCommandProxy;
import com.example.controllers.CreateUserCommand;
import com.example.controllers.CreateUserCommandProxy;
import com.example.controllers.DeleteMailCommand;
import com.example.controllers.DeleteUserCommand;
import com.example.controllers.DeleteUserCommandProxy;
import com.example.controllers.ICommand;
import com.example.controllers.UserDatabase;
import com.example.mail.Mail;
import com.example.users.User;
import com.google.gson.Gson;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/server")
/**
 * This is the request controller
 * @author Tony
 *
 */
public class EMailServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMailServerApplication.class, args);
		UserDatabase databaseSetupObject =new UserDatabase();
		databaseSetupObject.setupFileDatabase();		
	}
	
	@PostMapping("/user/register")
	public boolean registerUser(@RequestBody String newUserName) {
		CreateUserCommandProxy command = new CreateUserCommandProxy(newUserName);
		return command.execute();
	}
	
	
	//LOGIN is not ready yet
	//Need to prepare the caching steps which will load the necessary data
	//also need to check whether the get inbox is called in sequence
	/*@PostMapping("/user/login")
	public boolean loginUser(@RequestBody String userName) {
		//CreateUserCommandProxy command = new CreateUserCommandProxy(userName);
		return true ;//command.execute();
	}*/
	
	@PostMapping("/user/delete")
	public boolean deleteUser(@RequestBody String userName) {
		DeleteUserCommandProxy command = new DeleteUserCommandProxy(userName);
		return command.execute();
	}
	
	@PostMapping("/mail/send")
	public boolean sendMail(@RequestBody String mailJSON) {
		/*
		 * Next part is temporary until merging and trying with real data
		 * part to be added: JSON TO MAIL OBJECT PARSING
		 */
		Mail mail = new Mail();
		mail.setAttachements("picture.com");
		mail.setBody("Happy birthday to you!");
		mail.setSubject("HBD");
		mail.setFromEmail("mark");
		mail.setToEmail("vero");
		mail.setPriority(2);
		mail.setDate("today");
		mail.setID(1);
		
		CreateMailCommandProxy command = new CreateMailCommandProxy(mail);
		return command.execute();			
	}
	
	
	
	
	@DeleteMapping("/mail/delete")
	public boolean deleteMessage(@RequestParam String userName,@RequestParam int messageID,@RequestParam String collection) {
		ICommand command=new DeleteMailCommand(userName,messageID,collection);
		command.execute();
		return true;
	}

}
