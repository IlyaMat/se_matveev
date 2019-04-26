package sef.module12.activity;

import sef.my.myChat.chatModule12.User;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	
	public static final Chat CHAT = new Chat();
	
	private List<User> users;
	
	private List<String> chat;
	
	private Chat() {
		this.users = new ArrayList<User>();
		this.chat = new ArrayList<String>();
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void addMessage(User user, String message) {
		if (!this.users.contains(user)) {
			this.users.add(user);
			System.out.println("User " + user.getName() + " loggon" + System.lineSeparator());
		}
		
		this.chat.add(message);
		
		System.out.println(user.getName() + ": " + this.chat.get(this.chat.size() - 1) + System.lineSeparator());
	}

}
