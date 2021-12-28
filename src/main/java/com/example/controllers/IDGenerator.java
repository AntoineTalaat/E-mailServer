package com.example.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.mail.Mail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class IDGenerator {
	private int id=0;
	private String folderPath = "./accounts/";
	private Gson gson = new Gson();
	

	
	private void saveLatestIDData(int id) {
		Type listType = new TypeToken<Integer>() {
		}.getType();
		String jsontxt = this.gson.toJson(id, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + "/IDGenerator.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	private int getLatestIDFromFile() {
		File path = new File(this.folderPath + "/IDGenerator.JSON");
		String data = "";
		int currentID;
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

		Type listType = new TypeToken<Integer>() {
		}.getType();
		currentID = this.gson.fromJson(data, listType);
		return currentID;
	}
	
	public int getID() {
		int newid=this.id;
		if(id!=0) {
			id = id+1;
			newid=id;
		}	
		else {
			id= this.getLatestIDFromFile();
			newid=id;
		}
		this.saveLatestIDData(newid);
		return newid;
	}
}
