package com.example.users;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

public class UserCreator {
	private String dataPath = "./accounts/";
	
	public void createUser(String name,String password)
	{
		File folder=new File(dataPath+name);
		folder.mkdir();
		System.out.println("created Folder for user " + name + " with password " + password);
		SecurityInfo info=new SecurityInfo(name,password);
		Gson gson = new Gson();	
		String dataInfo=gson.toJson(info);
		String savePath=dataPath + name +"/SecurityInfo.JSON";
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(savePath);
			myWriter.write(dataInfo);
	        myWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		try {
			savePath=dataPath + name +"/SecurityInfo.JSON";
		      File myObj = new File(savePath);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter2 = new FileWriter(savePath);
		        myWriter2.write(dataInfo);
		        myWriter2.close();

		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			
		
			
	      
		
	      
	}
}
*/