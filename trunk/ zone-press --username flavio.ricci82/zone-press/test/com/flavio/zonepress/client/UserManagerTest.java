package com.flavio.zonepress.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

import com.flavio.zonepress.manager.UserManager;
import com.flavio.zonepress.model.User;


public class UserManagerTest extends TestCase{
	public static transient Logger log = Logger.getLogger(UserManagerTest.class.getName());
	private UserManager userManager;
	
	public void setUp(){
		userManager = new UserManager();
	}
	
	public void tearDown(){
		userManager = null;
	}
	
	public void testGetUsers(){
		log.log(Level.SEVERE, "ciao");
		//userManager.getUser("zozzao", "37244fly");
		User user = new User();
		user.setName("Flavio");
		user.setPassword("37244fly");
		user.setUserName("zozzao");
		userManager.saveUser(user);
		log.log(Level.SEVERE, "ciao");
	}
	
	
	
}