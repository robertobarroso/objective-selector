package com.seedtag.objectiveselector.domain;

import lombok.Data;

/**
 * Represents the enemies that are visible in one Coordinate
 * @author Roberto
 *
 */
@Data
public class ScannedCoordinate {
	
	private Coordinate coordinates;
	
	private Enemy enemy;
	
	// Allies number can be present or not. Null is possible.
	private Integer allies;
	
	/**
	 * Whether the Enemy of this coordinate is a Mech or not
	 * @return boolean
	 */
	public boolean isMechEnemy() {
		return EnemyTypeEnum.MECH == this.enemy.getType();
	}
	
	/**
	 * Whether the Enemy has Allies or not.
	 * @return boolean
	 */
	public boolean hasAllies() {
		return this.allies != null && this.allies > 0;
	}
	
	/**
	 * Calculate the distance between (0,0) and (x,y). 
	 * The hypotenuse of a right-angle triangle is used 
	 * @return double
	 */
	public double getDistance() {
		return Math.hypot(this.coordinates.getX(), this.coordinates.getY());
	}
}
