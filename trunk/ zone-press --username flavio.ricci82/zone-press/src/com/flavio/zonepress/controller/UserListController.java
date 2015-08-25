package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.manager.UserManager;
import com.flavio.zonepress.model.User;

public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 4203727667298599100L;
	private static final Logger log = Logger.getLogger(UserListController.class.getName());
	private UserManager userManager;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			userManager = new UserManager();
			log.log(Level.INFO, "viewing season list...");
			
			/*
			User u = new User();
			u.setName("Flavio");
			u.setPassword("37244fly");
			u.setUserName("zozzao");
			userManager.saveUser(u);
			*/
			
			List<User> users = userManager.getAllUsers();
			req.setAttribute("users", users);

			getServletContext().getRequestDispatcher("/userList.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}