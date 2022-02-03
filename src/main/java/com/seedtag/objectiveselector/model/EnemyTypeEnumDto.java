package com.seedtag.objectiveselector.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnemyTypeEnumDto {
	SOLDIER,
	MECH;
	
	@JsonCreator
	public static EnemyTypeEnumDto fromValue(String value) {
		return EnemyTypeEnumDto.valueOf(value.toUpperCase());
	}
}
