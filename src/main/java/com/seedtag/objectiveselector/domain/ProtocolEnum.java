package com.seedtag.objectiveselector.domain;

import lombok.Getter;
/**
 * Represents the strategy that droide want to use when it wants to attack.
 * @author Roberto
 *
 */
public enum ProtocolEnum {
	CLOSEST_ENEMIES(new ClosestEnemiesProtocolBehaviour()),
	FURTHEST_ENEMIES(new FurtherEnemiesProtocolBehaviour()),
	ASSIST_ALLIES(new AssistAlliesProtocolBehaviour()),
	AVOID_CROSSFIRE(new AvoidCrossfireProtocolBehaviour()),
	PRIORITIZE_MECH(new PrioritizeMechProtocolBehaviour()),
	AVOID_MECH(new AvoidMechProtocolBehaviour());
	
	@Getter
	private ProtocolBehaviour protocolBehaviour;
	
	private ProtocolEnum(ProtocolBehaviour protocolBehaviour) {
		this.protocolBehaviour = protocolBehaviour;
	}
}
