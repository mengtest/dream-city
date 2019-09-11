package com.dream.city.player.domain.mapper;


import com.dream.city.player.domain.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerMapper {

    int deleteByPlayerId(String playerId);

    int insertSelective(Player record);

    Player getPlayerById(String playerId);

    List<Player> getPlayers(Player player);

    int updateByPlayerId(Player record);

}