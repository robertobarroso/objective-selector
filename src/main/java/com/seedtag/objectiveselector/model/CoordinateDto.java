package com.seedtag.objectiveselector.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int x;
	
	private int y;
}
