package com.seedtag.objectiveselector.domain;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class AvoidCrossfireProtocolBehaviour implements ProtocolBehaviour {

	@Override
	public Optional<Predicate<ScannedCoordinate>> getPredicate() {
		return Optional.of(p -> p.getAllies() == null || p.getAllies() == 0);
	}

	@Override
	public Optional<Comparator<ScannedCoordinate>> getComparator() {
		return Optional.empty();
	}
}
