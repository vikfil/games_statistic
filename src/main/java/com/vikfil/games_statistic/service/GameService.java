package com.vikfil.games_statistic.service;

import com.vikfil.games_statistic.dto.GameDescriptionDto;
import com.vikfil.games_statistic.mapper.GameDescriptionMapper;
import com.vikfil.games_statistic.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {

    private final GameRepository freeGameRepositoryImpl;
    private final GameRepository paidGameRepositoryImpl;
    private final GameRepository grossingGameRepositoryImpl;
    private final GameDescriptionMapper gameDescriptionMapper;

    @Autowired
    public GameService(GameRepository freeGameRepositoryImpl, GameRepository paidGameRepositoryImpl,
                       GameRepository grossingGameRepositoryImpl, GameDescriptionMapper gameDescriptionMapper) {
        this.freeGameRepositoryImpl = freeGameRepositoryImpl;
        this.paidGameRepositoryImpl = paidGameRepositoryImpl;
        this.grossingGameRepositoryImpl = grossingGameRepositoryImpl;
        this.gameDescriptionMapper = gameDescriptionMapper;
    }

    public List<GameDescriptionDto> getFreeGame() {
        return gameDescriptionMapper.toDto(freeGameRepositoryImpl.findAllGames());
    }

    public List<GameDescriptionDto> getFreeGameByLimit(int limit) {
        return gameDescriptionMapper.toDto(freeGameRepositoryImpl.findGamesByLimit(limit));
    }

    public List<GameDescriptionDto> getPaidGame() {
        return gameDescriptionMapper.toDto(paidGameRepositoryImpl.findAllGames());
    }

    public List<GameDescriptionDto> getPaidGameByLimit(int limit) {
        return gameDescriptionMapper.toDto(paidGameRepositoryImpl.findGamesByLimit(limit));
    }

    public List<GameDescriptionDto> getGrossingGame() {
        return gameDescriptionMapper.toDto(grossingGameRepositoryImpl.findAllGames());
    }

    public List<GameDescriptionDto> getGrossingGameByLimit(int limit) {
        return gameDescriptionMapper.toDto(grossingGameRepositoryImpl.findGamesByLimit(limit));
    }
}
