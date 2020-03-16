package com.vikfil.games_statistic.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class GameDescription implements Serializable {

   private String artistName;
   private String releaseDate;
   private String name;
   private String url;

}
