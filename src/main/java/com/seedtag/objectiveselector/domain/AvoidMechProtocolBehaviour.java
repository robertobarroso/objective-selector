package com.seedtag.objectiveselector.domain;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class AvoidMechProtocolBehaviour implements ProtocolBehaviour {

	@Override
	public Optional<Predicate<ScannedCoordinate>> getPredicate() {
		return Optional.of(p -> !EnemyTypeEnum.MECH.equals(p.getEnemy().getType()));
	}

	@Override
	public Optional<Comparator<ScannedCoordinate>> getComparator() {
		return Optional.empty();
	}
}
