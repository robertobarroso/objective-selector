package com.seedtag.objectiveselector.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnemyDto  implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnemyTypeEnumDto type;
	
	private int number;
}
