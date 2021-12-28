package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.controllers.CreateUserCommandProxy;
import com.example.controllers.ICommandProxy;
import com.example.controllers.UserDatabase;

@SpringBootTest
class EMailServerApplicationTests {

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
	
	void sendMail() {
		
	}
}
