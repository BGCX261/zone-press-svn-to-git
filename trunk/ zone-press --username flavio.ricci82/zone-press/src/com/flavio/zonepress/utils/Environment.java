package com.flavio.zonepress.utils;

import javax.jdo.PersistenceManager;

public abstract class Environment {
	
	public PersistenceManager persistenceManager;
	
	public PersistenceManager getPersistenceManager(){
		this.persistenceManager = PMF.get().getPersistenceManager();
		return this.persistenceManager;
	}
	
	public void closePersistenceManager(){
		this.persistenceManager.close();
	}
}
