package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.manager.MatchManager;
import com.flavio.zonepress.model.Match;

public class MatchFormController extends HttpServlet {

	private static final long serialVersionUID = -2032027119700207631L;
	private static final Logger log = Logger
			.getLogger(MatchFormController.class.getName());
	private MatchManager matchManager;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			matchManager = new MatchManager();
			log.log(Level.INFO, "saving match...");

			Match match = new Match("virtus", "pro patria", "101", "32", new Date());
			matchManager.saveMatch(match);

			getServletContext().getRequestDispatcher("/matchList").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}