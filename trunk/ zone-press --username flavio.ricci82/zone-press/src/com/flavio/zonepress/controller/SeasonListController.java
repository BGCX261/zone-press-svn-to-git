package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.manager.SeasonManager;
import com.flavio.zonepress.model.Season;

public class SeasonListController extends HttpServlet {
	private static final long serialVersionUID = 4203727667298599100L;
	private static final Logger log = Logger.getLogger(SeasonListController.class.getName());
	private SeasonManager seasonManager;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			seasonManager = new SeasonManager();
			log.log(Level.INFO, "viewing season list...");
			List<Season> seasons = seasonManager.getAllSeasons();
			req.setAttribute("seasons", seasons);

			getServletContext().getRequestDispatcher("/seasonList.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}