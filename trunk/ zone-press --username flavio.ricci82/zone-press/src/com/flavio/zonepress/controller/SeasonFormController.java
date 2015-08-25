package com.flavio.zonepress.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flavio.zonepress.manager.SeasonManager;
import com.flavio.zonepress.model.Season;

public class SeasonFormController extends HttpServlet {

	private static final long serialVersionUID = -2032027119700207631L;
	private static final Logger log = Logger.getLogger(SeasonFormController.class.getName());
	private SeasonManager seasonManager;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			seasonManager = new SeasonManager();
			log.log(Level.INFO, "saving season...");

			Season season = new Season();
			season.setCurrent(false);
			season.setLabel("2009-2010");
			seasonManager.saveSeason(season);

			getServletContext().getRequestDispatcher("/seasonList").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}