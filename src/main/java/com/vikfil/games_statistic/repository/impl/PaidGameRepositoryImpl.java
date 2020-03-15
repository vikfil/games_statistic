package com.vikfil.games_statistic.repository.impl;

import com.vikfil.games_statistic.model.GameDescription;
import com.vikfil.games_statistic.repository.GameRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaidGameRepositoryImpl implements GameRepository {

    private static final String PAID_GAME = "PAID";
    private final RedisTemplate<String, GameDescription> redisTemplate;

    public PaidGameRepositoryImpl(RedisTemplate<String, GameDescription> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(List<GameDescription> gameDescription) {
        redisTemplate.opsForList().rightPushAll(PAID_GAME, gameDescription);

    }

    @Override
    public List<GameDescription> findAllGames() {
        return redisTemplate.opsForList().range(PAID_GAME, 0, -1);
    }

    @Override
    public List<GameDescription> findGamesByLimit(int limit) {
        return redisTemplate.opsForList().range(PAID_GAME, 0, limit-1);
    }

    @Override
    public void delete() {
        redisTemplate.delete(PAID_GAME);

    }
}
