package com.example.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is responsible for handling json file that contains users names
 * the class converts from json file to arraylist and vice versa
 * @author Antoine
 *
 */
public class UserDatabase {
	private String path="./accounts/database.JSON";
	private Gson gson = new Gson();
	

	
	public ArrayList<String> getUserListFromFile(){	
		File path  = new File(this.path);
		String data = "";
		ArrayList<String> users;
		try {
			Scanner myReader = new Scanner(path);
			while (myReader.hasNextLine()) {
		        data = data + myReader.nextLine();    
		     }	
			myReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Type listType = new TypeToken<ArrayList<String>>() {}.getType();
		users = this.gson.fromJson(data, listType);
		return users;
	}
	
	
	public void saveUserListToFile(ArrayList<String> users) {
		Type listType = new TypeToken<ArrayList<String>>() {}.getType();
		String jsontxt= this.gson.toJson(users,listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.path);
			myWriter.write(jsontxt);
	        myWriter.close();
	        
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void setupFileDatabase() {
		File baseFile = new File(this.path);
		boolean exists = baseFile.exists();
		try {
			if(!exists) {
				baseFile.createNewFile();
				ArrayList<User> users=new ArrayList<User>();
				String jsontxt= this.gson.toJson(users,ArrayList.class);
				FileWriter myWriter = new FileWriter("./accounts/"+"database.JSON");
				myWriter.write(jsontxt);
		        myWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
