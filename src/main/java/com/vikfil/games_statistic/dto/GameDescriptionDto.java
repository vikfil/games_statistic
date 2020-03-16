package com.vikfil.games_statistic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDescriptionDto implements Serializable {
    private String artistName;
    private String releaseDate;
    private String name;
    private String url;
}
