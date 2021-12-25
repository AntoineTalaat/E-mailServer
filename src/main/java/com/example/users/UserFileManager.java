package com.example.users;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserFileManager {
	private String dataPath="./accounts/";
	
	
	/**
	 * function that fetches the user object from files 
	 * @param name
	 * @return User object 
	 */
/*
	public User fetchUserInfo(String name) {
		
		
		File userFile = new File(dataPath + name);
		
		
		File path  = new File("./accounts/Test/SecurityInfo.JSON");
		Scanner myReader = null;
		try {
			myReader = new Scanner(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	        SecurityInfo tester=gson.fromJson(data, SecurityInfo.class);
	        System.out.println(" pasword of test is " + tester.getPassword());
	      }
	      myReader.close();
	}
}
*/