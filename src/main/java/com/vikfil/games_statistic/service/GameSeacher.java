package com.vikfil.games_statistic.service;

import com.vikfil.games_statistic.model.IncomingJsonParser;
import com.vikfil.games_statistic.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    public GameSeacher(GameRepository freeGameRepositoryImpl, GameRepository paidGameRepositoryImpl, GameRepository grossingGameRepositoryImpl, RestTemplate restTemplate) {
        this.freeGameRepositoryImpl = freeGameRepositoryImpl;
        this.paidGameRepositoryImpl = paidGameRepositoryImpl;
        this.grossingGameRepositoryImpl = grossingGameRepositoryImpl;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedDelay = 3600000)
    public void findFreeGames() {
        freeGameRepositoryImpl.delete();
        freeGameRepositoryImpl.save(getGamesFromLink(freeGameLink).getFeed().getResults());
    }

    @Scheduled(fixedDelay = 3600000)
    public void findPaidGames() {
        paidGameRepositoryImpl.delete();
        paidGameRepositoryImpl.save(getGamesFromLink(paidGameLink).getFeed().getResults());
    }

    @Scheduled(fixedDelay = 3600000)
    public void findGrossingGames() {
        grossingGameRepositoryImpl.delete();
        grossingGameRepositoryImpl.save(getGamesFromLink(grossingGameLink).getFeed().getResults());
    }

    private IncomingJsonParser getGamesFromLink(String urlAddress) {
        return restTemplate.getForObject(urlAddress, IncomingJsonParser.class);
    }
}
