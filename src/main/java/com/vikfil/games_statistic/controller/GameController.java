package com.vikfil.games_statistic.controller;

import com.vikfil.games_statistic.dto.GameDescriptionDto;
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

    private boolean isLimitCorrect(Integer limit) {
        return limit != null && limit > 0 && limit <= 100;
    }

    @GetMapping("/free")
    public List<GameDescriptionDto> freeGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return (isLimitCorrect(limit)) ? gameService.getFreeGameByLimit(limit) : gameService.getFreeGame();
    }

    @GetMapping("/paid")
    public List<GameDescriptionDto> paidGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return (isLimitCorrect(limit)) ? gameService.getPaidGameByLimit(limit) : gameService.getPaidGame();
    }

    @GetMapping("/grossing")
    public List<GameDescriptionDto> grossingGames(@RequestParam(name = "limit", required = false) Integer limit) {
        return (isLimitCorrect(limit)) ? gameService.getGrossingGameByLimit(limit) : gameService.getGrossingGame();
    }
}
