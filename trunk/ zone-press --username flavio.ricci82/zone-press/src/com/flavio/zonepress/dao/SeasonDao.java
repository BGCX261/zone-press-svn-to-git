package com.flavio.zonepress.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.flavio.zonepress.model.Season;

public class SeasonDao{
	
	private PersistenceManager persistenceManager;
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Season> getAllSeasons(){
		String query = "select from " + Season.class.getName();
		List<Season> seasons = (List<Season>) persistenceManager.newQuery(query).execute();
		List<Season> copy = new ArrayList<Season>();
		for (Season s : seasons){
			copy.add(s);
		}
		return copy;
	}
	
	public Season saveSeason(Season season){
        Season savedSeason = persistenceManager.makePersistent(season);
        return savedSeason;
	}

}
