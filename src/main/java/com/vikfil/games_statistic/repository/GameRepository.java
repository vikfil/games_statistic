package com.vikfil.games_statistic.repository;

import com.vikfil.games_statistic.model.GameDescription;
import java.util.List;

public interface GameRepository {
    void save(List<GameDescription> gameDescription);
    List<GameDescription> findGamesByLimit(int limit);
    List<GameDescription> findAllGames();
    void delete();
}
