package com.seedtag.objectiveselector.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProtocolEnumDto {
	@JsonProperty("closest-enemies")
	CLOSEST_ENEMIES,
	
	@JsonProperty("furthest-enemies")
	FURTHEST_ENEMIES,
	
	@JsonProperty("assist-allies")
	ASSIST_ALLIES,
	
	@JsonProperty("avoid-crossfire")
	AVOID_CROSSFIRE,
	
	@JsonProperty("prioritize-mech")
	PRIORITIZE_MECH,
	
	@JsonProperty("avoid-mech")
	AVOID_MECH;
	
}
