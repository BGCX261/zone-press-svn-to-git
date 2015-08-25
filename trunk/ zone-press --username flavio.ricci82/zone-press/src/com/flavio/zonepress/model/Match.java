package com.flavio.zonepress.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Match {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String homeTeam;
	
	@Persistent
	private String awayTeam;
	
	@Persistent
	private String pointsHome;
	
	@Persistent
	private String pointsAway;
	
	@Persistent
	private Date date;
	
	@Persistent
	private Season season;

	public Match(String homeTeam, String awayTeam, String pointsHome,
			String pointsAway, Date date) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.pointsHome = pointsHome;
		this.pointsAway = pointsAway;
		this.date = date;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getPointsHome() {
		return pointsHome;
	}

	public void setPointsHome(String pointsHome) {
		this.pointsHome = pointsHome;
	}

	public String getPointsAway() {
		return pointsAway;
	}

	public void setPointsAway(String pointsAway) {
		this.pointsAway = pointsAway;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

}
