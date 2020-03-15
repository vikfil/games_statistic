package com.vikfil.games_statistic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDescription implements Serializable {

   private String artistName;
   private String releaseDate;
   private String name;
   private String url;

}
