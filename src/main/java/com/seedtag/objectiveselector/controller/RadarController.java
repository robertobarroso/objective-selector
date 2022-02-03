package com.seedtag.objectiveselector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.mapper.CoordinateDtoMapper;
import com.seedtag.objectiveselector.mapper.ScannedEnemiesDtoMapper;
import com.seedtag.objectiveselector.model.CoordinateDto;
import com.seedtag.objectiveselector.model.ScannedEnemiesDto;
import com.seedtag.objectiveselector.service.RadarService;

//TODO: Write Swagger documentation through annotations.
// Currently there is some incompatibilities with recent Spring Boot versions. Some alternatives must be research.
@RestController
public class RadarController {

	@Autowired
	private ScannedEnemiesDtoMapper scannedEnemiesDtoMapper;
	
	@Autowired
	private CoordinateDtoMapper coordinateDtoMapper;
	
	@Autowired 
	RadarService radarService;
	
	@PostMapping(value="/radar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CoordinateDto> radar(@RequestBody ScannedEnemiesDto scannedEnemiesDto) {
		
		Coordinate coordinate = this.radarService.chooseObjective(this.scannedEnemiesDtoMapper.toDomain(scannedEnemiesDto));
		
		return ResponseEntity.ok(this.coordinateDtoMapper.toDto(coordinate));
	}
	
}
