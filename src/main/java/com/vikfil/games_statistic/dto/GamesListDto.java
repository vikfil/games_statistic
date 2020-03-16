package com.vikfil.games_statistic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GamesListDto implements Serializable {
    private List<GameDescriptionDto> results;
}
