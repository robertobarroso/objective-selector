package com.seedtag.objectiveselector.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.domain.ScannedEnemies;
import com.seedtag.objectiveselector.exception.BusinessException;

/**
 * Service class that contains the operations for the Radar. 
 * @author Roberto
 */
@Service
public class RadarServiceImpl implements RadarService {

	/**
	 *  Given the environment information {@link ScannedEnemies} the droid YVH can obtain the next coordinate to attack.
	 *  @return {@link Coordinate}
	 *  @throws BusinessException If any {@link Coordinate} is not found
	 */
	@Override
	public Coordinate chooseObjective(@Valid ScannedEnemies scannedEnemies) {
		return scannedEnemies.chooseObjective();
	}

}
