package com.seedtag.objectiveselector.mapper;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.model.CoordinateDto;

public interface CoordinateDtoMapper {
	
	public CoordinateDto toDto(Coordinate coordinate);
	
}
