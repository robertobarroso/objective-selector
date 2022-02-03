package com.seedtag.objectiveselector.service;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.domain.ScannedEnemies;

public interface RadarService {
	
	public Coordinate chooseObjective(ScannedEnemies scannedEnemies);
}
