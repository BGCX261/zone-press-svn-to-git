package com.flavio.zonepress.manager;

import java.util.List;

import com.flavio.zonepress.dao.SeasonDao;
import com.flavio.zonepress.model.Season;
import com.flavio.zonepress.utils.Environment;

public class SeasonManager extends Environment{

	private SeasonDao seasonDao;

	public SeasonManager(){
		setSeasonDao(new SeasonDao());
	}
	
	public void setSeasonDao(SeasonDao seasonDao) {
		this.seasonDao = seasonDao;
	}

	public List<Season> getAllSeasons(){
		seasonDao.setPersistenceManager(getPersistenceManager());
		List<Season> seasons = seasonDao.getAllSeasons();
		closePersistenceManager();
		return seasons;
	}
	
	public Season saveSeason(Season season){
		seasonDao.setPersistenceManager(getPersistenceManager());
        Season seasonSaved = seasonDao.saveSeason(season);
        closePersistenceManager();
        return seasonSaved;
	}
	
}
