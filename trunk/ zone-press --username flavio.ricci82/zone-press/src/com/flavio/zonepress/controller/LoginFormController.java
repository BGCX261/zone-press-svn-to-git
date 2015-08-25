package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flavio.zonepress.manager.UserManager;
import com.flavio.zonepress.model.User;

public class LoginFormController extends HttpServlet {

	private static final long serialVersionUID = -2032027119700207631L;
	private static final Logger log = Logger.getLogger(LoginFormController.class.getName());
	private UserManager userManager;

	private String userName;
	private String password;

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			HttpSession session = req.getSession(true);
			userManager = new UserManager();
			
			log.log(Level.INFO, "saving user...");
			formMapping(req);
			
			/*
			User user1=new User();
			user1.setUserName("zozzao");
			user1.setPassword("37244fly");
			user1.setName("Flavio");
			userDao.saveUser(user1);
			if (userDao.getUser(getUserName(), getPassword())!=null){
				//TODO: user exists
			}
			*/
			User user = userManager.getUser(getUserName(), getPassword());
			
			if (user!=null){
				log.log(Level.WARNING, "User " + getUserName() + " found");
				session.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
			} else {
				log.log(Level.INFO, "User " + getUserName() + " not found");
				getServletContext().getRequestDispatcher("/loginError.html").forward(req, resp);
			}
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void formMapping(HttpServletRequest request){
		setUserName(request.getParameter("username"));
		setPassword(request.getParameter("password"));
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}