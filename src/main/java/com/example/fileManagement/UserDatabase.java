package com.example.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import com.example.users.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.networknt.schema.JsonSchema;
//import com.networknt.schema.JsonSchemaFactory;
//import com.networknt.schema.SpecVersion;
//import com.networknt.schema.ValidationMessage;

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
		MetaDataObject database=this.getMetaDataObject();
		ArrayList<String> users=database.getUsers();
		return users;
	}

	
	public void saveUserListToFile(ArrayList<String> users) {
		MetaDataObject database = this.getMetaDataObject();
		database.setUsers(users);
		this.saveMetaDataObject(database);
	}

	
	public int getID() {
		int id = this.getMetaDataObject().getIdCount();
		this.saveLatestIDData(id+1);
		return id+1;
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
		MetaDataObject mdo = this.getMetaDataObject();
		mdo.setIdCount(id);
		this.saveMetaDataObject(mdo);
	}
	
	
	private void saveMetaDataObject(MetaDataObject mdo) {
		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
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
	private MetaDataObject getMetaDataObject(){
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

		try {
			//this.validateSchema(data);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		Type listType = new TypeToken<MetaDataObject>() {
		}.getType();
		MetaDataObject mdo = this.gson.fromJson(data, listType);
		return mdo;
	}
	
	
	
	/*
	
	private void validateSchema(String jsonData) throws JsonMappingException, JsonProcessingException, FileNotFoundException {
		ObjectMapper objectMapper = new ObjectMapper();  
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);   
        String schemaPath="D:\\College\\SEMESTER 3\\OOP\\Submissions\\E-mail Server\\BackEnd\\E-mailServer\\accounts\\databaseSchema.JSON";
        File path = new File(schemaPath);
		String schemaStr = "";

		Scanner myReader = new Scanner(path);
		while (myReader.hasNextLine()) {
			schemaStr = schemaStr + myReader.nextLine();
		}
		myReader.close();
        JsonNode json = objectMapper.readTree(jsonData);  
        JsonSchema schema = schemaFactory.getSchema(schemaStr);  
        Set<ValidationMessage> validationResult = schema.validate( json );  
        if (validationResult.isEmpty()) {    
            System.out.println( "There is no validation errors" );  
          
        } else {  
               validationResult.forEach(vm -> System.out.println(vm.getMessage()));  
        }  
        
	}
	*/

}
