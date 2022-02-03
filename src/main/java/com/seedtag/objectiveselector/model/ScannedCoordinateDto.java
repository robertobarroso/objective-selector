package com.seedtag.objectiveselector.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScannedCoordinateDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CoordinateDto coordinates;
	
	@JsonProperty("enemies")
	private EnemyDto enemy;
	
	// allies number present. Null is possible.
	private Integer allies;
}
