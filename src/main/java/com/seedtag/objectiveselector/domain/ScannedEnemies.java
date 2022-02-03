package com.seedtag.objectiveselector.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.seedtag.objectiveselector.exception.BusinessException;

import lombok.Data;

/**
 * Represent the coordinates that have been scanned by Vision module.
 * Each coordinate contains what enemies are eligible to attack.
 * @author Roberto
 */
@Data
public class ScannedEnemies {
	
	@NotNull
	private List<ProtocolEnum> protocols;
	
	@NotNull
	private List<ScannedCoordinate> scannedCoordinates;
	
	/** 
	 * Calculate the Coordinate that droide YVH will use to attack
	 * Consider the protocol list defined to decide which to choose.
	 * @return Coordinate
	 */
	public Coordinate chooseObjective() {
		// Construct a list of Predicates to filter List<ScannedCoordinate>. 
		// Each protocol could have one filter. Combine them into one Predicate with the "and" operator.
		Predicate<ScannedCoordinate> combinedPredicate = this.protocols.stream()
				.map(p -> p.getProtocolBehaviour().getPredicate())
				.flatMap(Optional::stream)
				.reduce(x->true, Predicate::and);
				
		// Construct a list of comparators. 
		// Each protocol could have one Comparator.
		List<Comparator<ScannedCoordinate>> comparatorList = this.protocols.stream()
				.map(p -> p.getProtocolBehaviour().getComparator())
				.flatMap(Optional::stream)
				.collect(Collectors.toList());
		
		// Filter the List<ScannedCoordinate> by combinedFilter.
		List<ScannedCoordinate> scannedCoordinatesCopy = this.scannedCoordinates.stream()
				.filter(combinedPredicate)
			    .collect(Collectors.toList());
		
		// Sort by comparatorList.
		for (Comparator<ScannedCoordinate> comparator : comparatorList) {
			scannedCoordinatesCopy.sort(comparator);
		}
		
		// Return the first Coordinate if exists
		if (scannedCoordinatesCopy.isEmpty()) {
			throw new BusinessException("BE001", "No coordinates found", "There is not coordinates according to the specified protocols");
		}
		return scannedCoordinatesCopy.get(0).getCoordinates();
	}
	
}
