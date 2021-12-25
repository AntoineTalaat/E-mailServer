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
		/**
		 * the next part is mainly to initialize the folder that keeps track of all saved users
		 * We can put that responsibility elsewhere Later
		 */
		File baseFile = new File("./accounts/"+"database.JSON");
		boolean exists = baseFile.exists();
		try {
			if(!exists) {
				baseFile.createNewFile();
				Gson gson = new Gson();	
				ArrayList<User> users=new ArrayList<User>();
				String jsontxt= gson.toJson(users,ArrayList.class);
				FileWriter myWriter = new FileWriter("./accounts/"+"database.JSON");
				myWriter.write(jsontxt);
		        myWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@PostMapping("/user/register")
	public boolean registerUser(@RequestBody String newUserName) {
		
		CreateUserCommand command = new CreateUserCommand();
		command.execute(newUserName);
		
		return true;
		
	}

}
