package com.example.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.commands.filterObject;
import com.example.mail.Mail;
import com.example.users.Contact;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONtoObjectConverter {
	private Gson gson = new Gson();
	
	public Mail convertStringToMail(String JSONstr) {
		Mail mail = new Mail();
		Type listType = new TypeToken<Mail>() {
		}.getType();
		mail = this.gson.fromJson(JSONstr, listType);
		return mail;
	}
	
	public Contact convertStringToContact(String JSONstr) {
		Contact contact = new Contact();
		Type listType = new TypeToken<Contact>() {
		}.getType();
		contact = this.gson.fromJson(JSONstr, listType);
		return contact;
	}
	
	public filterObject convertStringtoFilterObject(String JSONstr) {
		filterObject filter=new filterObject();
		Type listType = new TypeToken<filterObject>() {
		}.getType();
		filter = this.gson.fromJson(JSONstr, listType);
		return filter;
	}
}
