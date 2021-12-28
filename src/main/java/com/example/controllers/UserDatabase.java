package com.example.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.fileManagement.MetaDataObject;
import com.example.users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is responsible for handling json file that contains users names
 * the class converts from json file to arraylist and vice versa
 * 
 * @author Antoine
 *
 */
public class UserDatabase {
	private String path = "./accounts/database.JSON";
	private Gson gson = new Gson();

	public ArrayList<String> getUserListFromFile() {
		File path = new File(this.path);
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

		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
		MetaDataObject database=this.gson.fromJson(data, listType);
		users=database.getUsers();
		return users;
	}

	
	public void saveUserListToFile(ArrayList<String> users) {
		Type listType = new TypeToken<ArrayList<String>>() {}.getType();
		MetaDataObject database = this.readCurrentMetaData();
		database.setUsers(users);
		String jsontxt = this.gson.toJson(database, listType);
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

	
	private MetaDataObject readCurrentMetaData() {
		File path = new File(this.path);
		String data = "";
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

		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
		MetaDataObject database=this.gson.fromJson(data, listType);
		return database;
		
	}
	
	
	
	public void setupFileDatabase() {
		File baseFile = new File(this.path);
		boolean existsBase = baseFile.exists();
		
		try {
			if (!existsBase) {
				baseFile.createNewFile();
				MetaDataObject data= new MetaDataObject();
				data.setIdCount(1);
				data.setUsers(new ArrayList<String>());
				String jsontxt = this.gson.toJson(data, MetaDataObject.class);
				FileWriter myWriter = new FileWriter("./accounts/" + "database.JSON");
				myWriter.write(jsontxt);
				myWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	private void saveLatestIDData(int id) {
		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
		MetaDataObject mdo = this.readCurrentMetaData();
		mdo.setIdCount(id);
		String jsontxt = this.gson.toJson(mdo, listType);
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
	
	
	private int getLatestIDFromFile() {
		File path = new File(this.path);
		String data = "";
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

		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
		MetaDataObject mdo = this.gson.fromJson(data, listType);
		return mdo.getIdCount();
	}
	
	public int getID() {
		MetaDataObject mdo = new MetaDataObject();
		int id= mdo.getIdCount();
		this.saveLatestIDData(id+1);
		return id+1;
	}
	
	

}
