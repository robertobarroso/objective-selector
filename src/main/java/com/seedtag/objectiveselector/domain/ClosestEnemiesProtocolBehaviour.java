package com.seedtag.objectiveselector.domain;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class ClosestEnemiesProtocolBehaviour implements ProtocolBehaviour {

	@Override
	public Optional<Predicate<ScannedCoordinate>> getPredicate() {
		return Optional.empty();
	}

	@Override
	public Optional<Comparator<ScannedCoordinate>> getComparator() {
		return Optional.of(Comparator.comparing(ScannedCoordinate::getDistance));
	}

}
