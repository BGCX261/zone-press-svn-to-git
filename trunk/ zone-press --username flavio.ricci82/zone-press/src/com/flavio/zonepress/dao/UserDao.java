package com.flavio.zonepress.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.flavio.zonepress.model.User;

public class UserDao {
	
	private PersistenceManager persistenceManager;
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	
	public User saveUser(User user){
		User savedUser = null;
		savedUser = persistenceManager.makePersistent(user);
        return savedUser;
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String userName, String password){
		String query = "select from " + User.class.getName() + " WHERE userName == '" + userName + "' && " +
				"password == '" + password +"'";
		List<User> users = (List<User>) persistenceManager.newQuery(query).execute();
		User copy = null;
		if ((users!=null) && (users.size()>0)){
			copy = users.get(0);
		}
        return copy;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		String query = "select from " + User.class.getName();
		List<User> users = (List<User>) persistenceManager.newQuery(query).execute();
		List<User> copy = new ArrayList<User>();
		for (User u : users){
			copy.add(u);
		}
		return copy;
	}

}
