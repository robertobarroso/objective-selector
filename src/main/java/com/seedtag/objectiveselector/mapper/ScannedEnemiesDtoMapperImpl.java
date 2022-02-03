package com.seedtag.objectiveselector.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.seedtag.objectiveselector.domain.Coordinate;
import com.seedtag.objectiveselector.domain.Enemy;
import com.seedtag.objectiveselector.domain.EnemyTypeEnum;
import com.seedtag.objectiveselector.domain.ProtocolEnum;
import com.seedtag.objectiveselector.domain.ScannedCoordinate;
import com.seedtag.objectiveselector.domain.ScannedEnemies;
import com.seedtag.objectiveselector.model.CoordinateDto;
import com.seedtag.objectiveselector.model.EnemyDto;
import com.seedtag.objectiveselector.model.ProtocolEnumDto;
import com.seedtag.objectiveselector.model.ScannedCoordinateDto;
import com.seedtag.objectiveselector.model.ScannedEnemiesDto;

// TODO: Alternatively, this mapper could be generated automatically by Mapstruct library.
@Component
public class ScannedEnemiesDtoMapperImpl implements ScannedEnemiesDtoMapper {

	@Override
	public ScannedEnemies toDomain(ScannedEnemiesDto scannedEnemiesDto) {
		if (scannedEnemiesDto == null) {
			return null;
		}
		ScannedEnemies scannedEnemies = new ScannedEnemies();
		scannedEnemies.setProtocols(protocolsDtoToProtocol(scannedEnemiesDto.getProtocols()));
		scannedEnemies.setScannedCoordinates(scannedCoordinatesDtoToScannedCoordinates(scannedEnemiesDto.getScannedCoordinates()));
		return scannedEnemies;
	}

	private List<ProtocolEnum> protocolsDtoToProtocol(List<ProtocolEnumDto> protocolListDto) {
		List<ProtocolEnum> protocolList = new ArrayList<>();
		if (protocolListDto != null) {
			for (ProtocolEnumDto protocolEnumDto : protocolListDto) {
				protocolList.add(ProtocolEnum.valueOf(protocolEnumDto.name()));
			}	
		}
		return protocolList;
	}


	private List<ScannedCoordinate> scannedCoordinatesDtoToScannedCoordinates(
			List<ScannedCoordinateDto> scannedCoordinateListDto) {
		
		List<ScannedCoordinate> scannedCoordinateList = new ArrayList<>();
		if (scannedCoordinateListDto != null) {
			for (ScannedCoordinateDto scannedCoordinateDto : scannedCoordinateListDto) {
				ScannedCoordinate scannedCoordinate = new ScannedCoordinate();
				scannedCoordinate.setCoordinates(coordinateDtoToCoordinate(scannedCoordinateDto.getCoordinates()));
				scannedCoordinate.setEnemy(enemyDtoToEnemy(scannedCoordinateDto.getEnemy()));
				scannedCoordinate.setAllies(scannedCoordinateDto.getAllies());
				scannedCoordinateList.add(scannedCoordinate);
			}	
		}
		return scannedCoordinateList;
	}

	private Coordinate coordinateDtoToCoordinate(CoordinateDto coordinateDto) {
		if (coordinateDto != null) {
			return new Coordinate(coordinateDto.getX(), coordinateDto.getY());
		}
		return null;
	}
	
	private Enemy enemyDtoToEnemy(EnemyDto enemyDto) {
		if (enemyDto != null) {
			Enemy enemy = new Enemy();
			enemy.setType(EnemyTypeEnum.valueOf(enemyDto.getType().name()));
			enemy.setNumber(enemyDto.getNumber());
			return enemy;
		}
		return null;
	}
}
