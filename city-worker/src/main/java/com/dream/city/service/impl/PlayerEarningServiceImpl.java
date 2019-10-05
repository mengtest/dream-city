package com.dream.city.service.impl;

import com.dream.city.base.model.entity.EarnIncomeLog;
import com.dream.city.base.model.entity.PlayerEarning;
import com.dream.city.base.model.mapper.EarnIncomeLogMapper;
import com.dream.city.base.model.mapper.PlayerEarningMapper;
import com.dream.city.service.PlayerEarningService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author Wvv
 */
public class PlayerEarningServiceImpl  implements PlayerEarningService {
    @Autowired
    PlayerEarningMapper playerEarningMapper;

    @Autowired
    EarnIncomeLogMapper earnIncomeLogMapper;

    @Override
    public List<PlayerEarning> getPlayerEarnByPlayerId(String playerId) {
        return playerEarningMapper.getPlayerEarningByPlayerId(playerId);
    }

    @Override
    public PlayerEarning getPlayerEarnByPlayerId(String playerId, Integer investId) {
        return playerEarningMapper.getPlayerEarning(playerId, investId);
    }

    @Override
    public void add(PlayerEarning earning) {
        playerEarningMapper.insertSelective(earning);
    }

    @Override
    public void update(PlayerEarning playerEarning) {
        playerEarningMapper.updateByPrimaryKeySelective(playerEarning);
    }

    @Override
    public void addEarnLog(EarnIncomeLog earnIncomeLog) {
        earnIncomeLogMapper.add(earnIncomeLog);
    }
}