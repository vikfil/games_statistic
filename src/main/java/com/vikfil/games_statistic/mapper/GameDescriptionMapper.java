package com.vikfil.games_statistic.mapper;

import com.vikfil.games_statistic.dto.GameDescriptionDto;
import com.vikfil.games_statistic.model.GameDescription;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface GameDescriptionMapper {
    List<GameDescription> toEntity(List<GameDescriptionDto> gamesDescriptionDto);
    List<GameDescriptionDto> toDto(List<GameDescription> gamesDescription);
}
