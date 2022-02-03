package com.seedtag.objectiveselector.domain;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Each protocol has an specific behavior. This interface define the contract of those operations.
 * @author Roberto
 *
 */
public interface ProtocolBehaviour {

	Optional<Predicate<ScannedCoordinate>> getPredicate();
	
	Optional<Comparator<ScannedCoordinate>> getComparator();
	
}
