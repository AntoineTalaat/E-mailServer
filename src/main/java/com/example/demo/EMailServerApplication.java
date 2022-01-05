package com.example.demo;


import java.lang.reflect.Type;
import java.util.ArrayList;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.commands.AddContactCommand;
import com.example.commands.AddToDraftCommand;
import com.example.commands.CreateMailCommandProxy;
import com.example.commands.CreateUserCommandProxy;
import com.example.commands.DeleteContactCommand;
import com.example.commands.DeleteMailCommand;
import com.example.commands.DeleteUserCommandProxy;
import com.example.commands.EditContactCommand;
import com.example.commands.FilterCommand;
import com.example.commands.GetContactsCommand;
import com.example.commands.GetMailsCommand;
import com.example.commands.ICommand;
import com.example.commands.ICommandProxy;
import com.example.commands.IContactCommand;
import com.example.commands.IMailCommand;
import com.example.commands.LoginCommandProxy;
import com.example.commands.RestoreFromTrashCommand;
import com.example.commands.SearchByWordCommand;
import com.example.commands.SearchContactCommand;
import com.example.commands.SortContactFolderCommand;
import com.example.commands.SortMailFolderCommand;
import com.example.commands.filterObject;
import com.example.controllers.JSONtoObjectConverter;
import com.example.controllers.UserUUIDConverter;
import com.example.fileManagement.UserDatabase;
import com.example.mail.Mail;
import com.example.users.Contact;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
	private UserUUIDConverter converter = new UserUUIDConverter();
	private UserDatabase idGenerator = new UserDatabase();
	
	public static void main(String[] args) {
		SpringApplication.run(EMailServerApplication.class, args);
		UserDatabase databaseSetupObject =new UserDatabase();
		databaseSetupObject.setupFileDatabase();			
	}
	
	

	
	
	//////////USER ACCOUNT////////////////////////////////////
	@PostMapping("/user/register")
	public boolean registerUser(@RequestBody String newUserName) {
		ICommandProxy command = new CreateUserCommandProxy(newUserName);
		return command.execute();
	}
	
	@PostMapping("/user/login")
	public String loginUser(@RequestBody String userName) {
		ICommandProxy command = new LoginCommandProxy(userName);
		String response="0";
		if (command.execute()) {
			response=converter.convertToUUID(userName);
		}
		return response;		
	}
	
	@PostMapping("/user/logout")
	public void logoutUser(@RequestBody String sessionID) {
		this.converter.removeIdMapping(sessionID);
		//TO DO remove from cache		
	}
	
	@PostMapping("/user/delete")
	public boolean deleteUser(@RequestBody String userName) {
		ICommandProxy command = new DeleteUserCommandProxy(userName);
		return command.execute();
	}
	
	
	
	//////////MAIL HANDLING////////////////////////////////////
	@PostMapping("/mail/send")
	public boolean sendMail(@RequestBody String mailJSON) {
		JSONtoObjectConverter objectConverter = new JSONtoObjectConverter();
		Mail mail = objectConverter.convertStringToMail(mailJSON);
		mail.setId(this.idGenerator.getID());
		ICommandProxy command = new CreateMailCommandProxy(mail);
		return command.execute();
	}
	
	@DeleteMapping("/mail/delete")
	public void deleteMessage(@RequestParam String id,@RequestParam int messageID,@RequestParam String collection) {
		String userName = this.converter.convertToAccount(id);
		ICommand command=new DeleteMailCommand(userName,messageID,collection);
		command.execute();
		
	}

	@PostMapping("/mail/addToDraft")
	public void addMailToDraft(@RequestBody String mailJSON) {
		JSONtoObjectConverter objectConverter = new JSONtoObjectConverter();
		Mail mail = objectConverter.convertStringToMail(mailJSON);
		ICommand command = new AddToDraftCommand(mail);
		command.execute();
	}
	
	@GetMapping("/mail/restore")
	public void restoreFromTrash(@RequestParam String userID ,@RequestParam int mailID) {
		String userName=this.converter.convertToAccount(userID);
		ICommand command = new RestoreFromTrashCommand(userName,mailID);
		command.execute();
	}
	
	@GetMapping("/user/getMailFolder")
	public ArrayList<Mail> getMails(@RequestParam String userID,@RequestParam String folder){
		String userName=this.converter.convertToAccount(userID);
		GetMailsCommand command = new GetMailsCommand(userName,folder);
		return command.execute();
	}
	
	@GetMapping("/mail/sort")
	public ArrayList<Mail> getMailsSorted(@RequestParam String userID,@RequestParam String folder,@RequestParam String criteria){
		String userName=this.converter.convertToAccount(userID);
		IMailCommand command = new SortMailFolderCommand(userName,folder,criteria);
		return command.execute();
	}
	
	@GetMapping("/mail/search")
	public ArrayList<Mail> searchMailFolder(@RequestParam String userID,@RequestParam String folder,@RequestParam String searchWord){
		String userName=this.converter.convertToAccount(userID);
		IMailCommand command = new SearchByWordCommand(userName,folder,searchWord);
		return command.execute();
	}
	
	@GetMapping("/mail/filter")
	public ArrayList<Mail> filterMailFolder(@RequestParam String userID,
											@RequestParam String folder,
											@RequestParam String filtersJSON){
		
		JSONtoObjectConverter converter=new JSONtoObjectConverter();
		filterObject filters=converter.convertStringtoFilterObject(filtersJSON);
		System.out.println("filters " + filters.getPriority()+" " + filters.getSender() + " " + filters.getSubject());
		String userName=this.converter.convertToAccount(userID);
		IMailCommand command = new FilterCommand(userName,folder,filters);
		return command.execute();
	}
	
	
	//////////CONTACT HANDLING////////////////////////////////////
	@GetMapping("/user/addContact")
	public void addContact(@RequestParam String userID, @RequestParam String contactJSON) {
		String userName=this.converter.convertToAccount(userID);
		JSONtoObjectConverter objectConverter = new JSONtoObjectConverter();
		Contact contact = objectConverter.convertStringToContact(contactJSON);
		contact.setContactID(idGenerator.getID());
		ICommand command = new AddContactCommand(userName,contact);
		command.execute();
	}
	
	@DeleteMapping("/user/deleteContact")
	public void deleteContact(@RequestParam String userID,@RequestParam int contactID) {
		String userName=this.converter.convertToAccount(userID);
		ICommand command = new DeleteContactCommand(userName,contactID);
		command.execute();
	}
	
	@GetMapping("/user/searchContacts")
	public ArrayList<Contact> searchContactFolder(@RequestParam String userID,@RequestParam String searchWord){
		String userName=this.converter.convertToAccount(userID);
		IContactCommand command = new SearchContactCommand(userName,searchWord);
		return command.execute();
	}
	
	@GetMapping("/user/sortContacts")
	public ArrayList<Contact> sortContactFolder(@RequestParam String userID){
		String userName=this.converter.convertToAccount(userID);
		IContactCommand command = new SortContactFolderCommand(userName);
		return command.execute();
	}
	
	@PostMapping("/user/editContact")
	public void editContact(@RequestParam String userID,@RequestParam int contactID,@RequestParam String newName) {
		String userName=this.converter.convertToAccount(userID);
		ICommand command = new EditContactCommand(userID,contactID,newName);
		command.execute();
	}
	
	@GetMapping("/user/getContacts")
	public ArrayList<Contact> getContacts(@RequestParam String userID){
		String userName=this.converter.convertToAccount(userID);
		IContactCommand command = new GetContactsCommand(userName);
		return command.execute();
	}
	
	
	
	

}
