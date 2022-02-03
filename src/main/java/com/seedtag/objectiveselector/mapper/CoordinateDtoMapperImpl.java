package com.seedtag.objectiveselector.mapper;

import org.springframework.stereotype.Component;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.model.CoordinateDto;

// TODO: Alternatively, this Mapper could be generated automatically by Mapstruct library.
@Component
public class CoordinateDtoMapperImpl implements CoordinateDtoMapper {

	@Override
	public CoordinateDto toDto(Coordinate coordinate) {
		return new CoordinateDto(coordinate.getX(), coordinate.getY());
	}

	
}
