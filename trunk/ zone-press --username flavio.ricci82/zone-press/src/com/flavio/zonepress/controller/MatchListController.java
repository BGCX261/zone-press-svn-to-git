package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.manager.MatchManager;
import com.flavio.zonepress.model.Match;

public class MatchListController extends HttpServlet {
	private static final long serialVersionUID = 4203727667298599100L;
	private static final Logger log = Logger.getLogger(MatchListController.class.getName());
	private MatchManager matchManager;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			matchManager = new MatchManager();
			log.log(Level.INFO, "viewing match list...");
			List<Match> matches = matchManager.getAllMatches();
			req.setAttribute("matches", matches);

			getServletContext().getRequestDispatcher("/matchList.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}