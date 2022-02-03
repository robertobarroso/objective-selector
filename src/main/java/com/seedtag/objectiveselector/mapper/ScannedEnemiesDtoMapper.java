package com.seedtag.objectiveselector.mapper;

import com.seedtag.objectiveselector.domain.ScannedEnemies;
import com.seedtag.objectiveselector.model.ScannedEnemiesDto;

public interface ScannedEnemiesDtoMapper {
	
	public ScannedEnemies toDomain(ScannedEnemiesDto scannedEnemiesDto);
	
}
