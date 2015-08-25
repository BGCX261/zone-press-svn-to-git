package com.flavio.zonepress.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.flavio.zonepress.model.Match;

public class MatchDao{
	
	private PersistenceManager persistenceManager;
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getAllMatches(){
		String query = "select from " + Match.class.getName();
		List<Match> matches = (List<Match>) persistenceManager.newQuery(query).execute();
		List<Match> copy = new ArrayList<Match>();
		for (Match m : matches){
			copy.add(m);
		}
		return copy;
	}
	
	public Match saveMatch(Match match){
        Match savedMatch = persistenceManager.makePersistent(match);
        return savedMatch;
	}

}
