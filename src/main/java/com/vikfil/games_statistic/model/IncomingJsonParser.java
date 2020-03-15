package com.vikfil.games_statistic.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class IncomingJsonParser implements Serializable {
    private GamesList feed;
}
