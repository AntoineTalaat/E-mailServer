package com.example.fileManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.example.users.SecurityInfo;
import com.google.gson.Gson;

public class UserFileCreator {
	public String dataPath="./accounts/";
	
	public void create(String name) {
		File folder=new File(dataPath+name);
		folder.mkdir();
	}
}
