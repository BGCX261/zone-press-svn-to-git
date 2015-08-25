package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.model.Test;
import com.flavio.zonepress.utils.PMF;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class TestController extends HttpServlet {

	private static final long serialVersionUID = -8937184755471856293L;
	private static final Logger log = Logger.getLogger(TestController.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
    	doPost(req, resp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
    	
    	log.log(Level.INFO, "ok");
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        //Test test = new Test(user.toString());
        Test test = new Test("prova");

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(test);
        } finally {
            pm.close();
        }

        resp.sendRedirect("/test.jsp");
    }
}