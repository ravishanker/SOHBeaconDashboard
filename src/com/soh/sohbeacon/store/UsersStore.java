package com.soh.sohbeacon.store;

import java.util.ArrayList;

public class UsersStore {
	private ArrayList<String> users = new ArrayList<String>();

	private static UsersStore _instance = new UsersStore();
	
	public static UsersStore getInstance() {
		return _instance;
	}

	private UsersStore() {
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	
	public void addUser(String user) {
		users.add(user);
	}
}
