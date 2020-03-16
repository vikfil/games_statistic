package com.vikfil.games_statistic.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class IncomingJsonParserDto implements Serializable {
    private GamesListDto feed;
}
