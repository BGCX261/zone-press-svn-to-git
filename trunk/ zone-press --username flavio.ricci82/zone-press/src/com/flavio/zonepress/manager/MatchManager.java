package com.flavio.zonepress.manager;

import java.util.List;

import com.flavio.zonepress.dao.MatchDao;
import com.flavio.zonepress.model.Match;
import com.flavio.zonepress.utils.Environment;

public class MatchManager extends Environment{
	private MatchDao matchDao;

	public MatchManager(){
		setMatchDao(new MatchDao());
	}
	
	public void setMatchDao(MatchDao matchDao) {
		this.matchDao = matchDao;
	}
	
	public List<Match> getAllMatches(){
		matchDao.setPersistenceManager(getPersistenceManager());
		List<Match> matches = matchDao.getAllMatches();
		closePersistenceManager();
		return matches;
	}
	
	public Match saveMatch(Match match){
		matchDao.setPersistenceManager(getPersistenceManager());
        Match matchSaved = matchDao.saveMatch(match);
        closePersistenceManager();
        return matchSaved;
	}
	
}
