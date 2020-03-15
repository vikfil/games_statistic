package com.vikfil.games_statistic.service;

import com.vikfil.games_statistic.model.GameDescription;
import com.vikfil.games_statistic.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository freeGameRepositoryImpl;
    private final GameRepository paidGameRepositoryImpl;
    private final GameRepository grossingGameRepositoryImpl;

    @Autowired
    public GameService(GameRepository freeGameRepositoryImpl, GameRepository paidGameRepositoryImpl, GameRepository grossingGameRepositoryImpl) {
        this.freeGameRepositoryImpl = freeGameRepositoryImpl;
        this.paidGameRepositoryImpl = paidGameRepositoryImpl;
        this.grossingGameRepositoryImpl = grossingGameRepositoryImpl;
    }

    public List<GameDescription> getFreeGame() {
        return freeGameRepositoryImpl.findAllGames();
    }

    public List<GameDescription> getFreeGameByLimit(int limit) {
        return freeGameRepositoryImpl.findGamesByLimit(limit);
    }

    public List<GameDescription> getPaidGame() {
        return paidGameRepositoryImpl.findAllGames();
    }

    public List<GameDescription> getPaidGameByLimit(int limit) {
        return paidGameRepositoryImpl.findGamesByLimit(limit);
    }

    public List<GameDescription> getGrossingGame() {
        return grossingGameRepositoryImpl.findAllGames();
    }

    public List<GameDescription> getGrossingGameByLimit(int limit) {
        return grossingGameRepositoryImpl.findGamesByLimit(limit);
    }
}
