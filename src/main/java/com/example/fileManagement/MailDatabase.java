package com.example.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.mail.Mail;
import com.example.users.Contact;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is responsible for converting the data from files to arraylists of
 * Mail Object
 * 
 * @author Tony
 *
 */
public class MailDatabase {
	private String folderPath = "./accounts/";
	private Gson gson = new Gson();
	private String userName;

	public MailDatabase(String userName) {
		this.userName = userName;
	}

	public ArrayList<Mail> getInboxData() {
		File path = new File(this.folderPath + this.userName + "/inbox.JSON");
		String data = "";
		ArrayList<Mail> inbox;
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

		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		inbox = this.gson.fromJson(data, listType);
		return inbox;
	}

	public void saveInboxData(ArrayList<Mail> inbox) {
		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		String jsontxt = this.gson.toJson(inbox, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + this.userName + "/inbox.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<Mail> getSentData() {
		File path = new File(this.folderPath + this.userName + "/sent.JSON");
		String data = "";
		ArrayList<Mail> sent;
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

		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		sent = this.gson.fromJson(data, listType);
		return sent;
	}

	public void saveSentData(ArrayList<Mail> sent) {
		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		String jsontxt = this.gson.toJson(sent, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + this.userName + "/sent.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<Mail> getTrashData() {
		File path = new File(this.folderPath + this.userName + "/trash.JSON");
		String data = "";
		ArrayList<Mail> trash;
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

		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		trash = this.gson.fromJson(data, listType);
		return trash;
	}

	public void saveTrashData(ArrayList<Mail> trash) {
		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		String jsontxt = this.gson.toJson(trash, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + this.userName + "/trash.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<Mail> getDraftData() {
		File path = new File(this.folderPath + this.userName + "/draft.JSON");
		String data = "";
		ArrayList<Mail> draft;
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

		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		draft = this.gson.fromJson(data, listType);
		return draft;
	}

	public void saveDraftData(ArrayList<Mail> trash) {
		Type listType = new TypeToken<ArrayList<Mail>>() {
		}.getType();
		String jsontxt = this.gson.toJson(trash, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + this.userName + "/draft.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public ArrayList<Contact> getContactsData() {
		File path = new File(this.folderPath + this.userName + "/contacts.JSON");
		String data = "";
		ArrayList<Contact> contacts;
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

		Type listType = new TypeToken<ArrayList<Contact>>() {
		}.getType();
		contacts = this.gson.fromJson(data, listType);
		return contacts;
	}
	
	
	
	public void saveContactsData(ArrayList<Contact> contacts) {
		Type listType = new TypeToken<ArrayList<Contact>>() {
		}.getType();
		String jsontxt = this.gson.toJson(contacts, listType);
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(this.folderPath + this.userName + "/contacts.JSON");
			myWriter.write(jsontxt);
			myWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
