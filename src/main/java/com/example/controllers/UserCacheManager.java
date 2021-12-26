package com.example.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.users.User;

public class UserCacheManager {
	private HashMap<String,User> loggedInUsers;
	private UserCacheManager instance = new UserCacheManager();
	private UserDatabase users;
	
	
	private UserCacheManager() {
		this.loggedInUsers=new HashMap<String,User>();
		this.users = new UserDatabase();
	}
	
	public UserCacheManager getInstance() {
		return this.instance;
	}
	
	
	public void addUser(User user) {
		this.loggedInUsers.put(user.getName(), user);
	}
	
	public User fetchUser(String userName) {
		return loggedInUsers.get(userName);
	}
	
	public boolean isFetched(String userName) {
		return loggedInUsers.containsKey(userName);
	}
	
	public void removeUser(String userName) {
		this.loggedInUsers.remove(userName);
	}
	
}
