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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.CreateUserCommand;
import com.example.controllers.CreateUserCommandProxy;
import com.example.controllers.UserDatabase;
import com.example.users.User;
import com.google.gson.Gson;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/mail")
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
	
	@PostMapping("/user/login")
	public boolean loginUser(@RequestBody String userName) {
		CreateUserCommandProxy command = new CreateUserCommandProxy(userName);
		return command.execute();
	}
	
	

}
