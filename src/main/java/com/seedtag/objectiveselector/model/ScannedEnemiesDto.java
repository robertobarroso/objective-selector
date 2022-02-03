package com.seedtag.objectiveselector.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScannedEnemiesDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ProtocolEnumDto> protocols;
	
	@JsonProperty("scan")
	private List<ScannedCoordinateDto> scannedCoordinates;
}
