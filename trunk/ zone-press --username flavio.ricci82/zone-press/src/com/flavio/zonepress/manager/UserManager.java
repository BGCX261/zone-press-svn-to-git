package com.flavio.zonepress.manager;

import java.util.List;

import com.flavio.zonepress.dao.UserDao;
import com.flavio.zonepress.model.User;
import com.flavio.zonepress.utils.Environment;

public class UserManager extends Environment{
	private UserDao userDao;

	public UserManager(){
		setUserDao(new UserDao());
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User saveUser(User user){
		userDao.setPersistenceManager(getPersistenceManager());
		User userSaved = userDao.saveUser(user);
		closePersistenceManager();
		return userSaved;
	}
	
	public User getUser(String userName, String password){
		userDao.setPersistenceManager(getPersistenceManager());
		User user = userDao.getUser(userName, password);
		closePersistenceManager();
		return user;
	}
	
	public List<User> getAllUsers(){
		userDao.setPersistenceManager(getPersistenceManager());
		List<User> users = userDao.getAllUsers();
		closePersistenceManager();
		return users;
	}
	
}
