package com.vikfil.games_statistic.service;

import com.vikfil.games_statistic.dto.GameDescriptionDto;
import com.vikfil.games_statistic.dto.IncomingJsonParserDto;
import com.vikfil.games_statistic.mapper.GameDescriptionMapper;
import com.vikfil.games_statistic.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GameSeacher {

    @Value("${free.game}")
    private String freeGameLink;
    @Value("${paid.game}")
    private String paidGameLink;
    @Value("${grossing.game}")
    private String grossingGameLink;

    private final GameRepository freeGameRepositoryImpl;
    private final GameRepository paidGameRepositoryImpl;
    private final GameRepository grossingGameRepositoryImpl;
    private final RestTemplate restTemplate;
    private final GameDescriptionMapper gameDescriptionMapper;

    @Autowired
    public GameSeacher(GameRepository freeGameRepositoryImpl, GameRepository paidGameRepositoryImpl,
                       GameRepository grossingGameRepositoryImpl, RestTemplate restTemplate, GameDescriptionMapper gameDescriptionMapper) {
        this.freeGameRepositoryImpl = freeGameRepositoryImpl;
        this.paidGameRepositoryImpl = paidGameRepositoryImpl;
        this.grossingGameRepositoryImpl = grossingGameRepositoryImpl;
        this.restTemplate = restTemplate;
        this.gameDescriptionMapper = gameDescriptionMapper;
    }

    private IncomingJsonParserDto getGamesFromLink(String urlAddress) {
        return restTemplate.getForObject(urlAddress, IncomingJsonParserDto.class);
    }

    @Scheduled(fixedDelay = 3600000)
    public void findFreeGames() {
        List<GameDescriptionDto> freeGames = getGamesFromLink(freeGameLink).getFeed().getResults();
        freeGameRepositoryImpl.delete();
        freeGameRepositoryImpl.save(gameDescriptionMapper.toEntity(freeGames));
    }

    @Scheduled(fixedDelay = 3600000)
    public void findPaidGames() {
        List<GameDescriptionDto> paidGames = getGamesFromLink(paidGameLink).getFeed().getResults();
        paidGameRepositoryImpl.delete();
        paidGameRepositoryImpl.save(gameDescriptionMapper.toEntity(paidGames));
    }

    @Scheduled(fixedDelay = 3600000)
    public void findGrossingGames() {
        List<GameDescriptionDto> grossingGames = getGamesFromLink(grossingGameLink).getFeed().getResults();
        grossingGameRepositoryImpl.delete();
        grossingGameRepositoryImpl.save(gameDescriptionMapper.toEntity(grossingGames));
    }
}
