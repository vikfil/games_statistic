package com.vikfil.games_statistic.controller;

import com.vikfil.games_statistic.model.GameDescription;
import com.vikfil.games_statistic.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/ios/games/charts")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/free")
    public List<GameDescription> freeGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return isLimitCorrect(limit) ? gameService.getFreeGameByLimit(limit) : gameService.getFreeGame();
    }

    @GetMapping("/paid")
    public List<GameDescription> paidGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return isLimitCorrect(limit) ? gameService.getPaidGameByLimit(limit) : gameService.getPaidGame();
    }

    @GetMapping("/grossing")
    public List<GameDescription> grossingGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return isLimitCorrect(limit) ? gameService.getGrossingGameByLimit(limit) : gameService.getGrossingGame();
    }

    private boolean isLimitCorrect(Integer limit) {
        return limit != null && limit > 0 && limit <= 100;
    }
}
