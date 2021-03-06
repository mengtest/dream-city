package com.dream.city.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dream.city.base.exception.BusinessException;
import com.dream.city.base.model.entity.EarnIncomeLog;
import com.dream.city.base.model.entity.PlayerEarning;
import com.dream.city.base.model.mapper.EarnIncomeLogMapper;
import com.dream.city.base.model.mapper.PlayerEarningMapper;
import com.dream.city.base.model.resp.PlayerEarningResp;
import com.dream.city.service.PlayerEarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Wvv
 */
@Service
public class PlayerEarningServiceImpl  implements PlayerEarningService {
    @Autowired
    PlayerEarningMapper playerEarningMapper;

    @Autowired
    EarnIncomeLogMapper earnIncomeLogMapper;

    @LcnTransaction
    @Transactional
    @Override
    public List<PlayerEarning> getPlayerEarnByPlayerId(String playerId)throws BusinessException {
        PlayerEarning record = new PlayerEarning();
        record.setEarnPlayerId(playerId);
        return playerEarningMapper.selectPlayerEarningList(record);
    }

    @Override
    public PlayerEarningResp getPlayerEarnByPlayerId(String playerId, Integer investId)throws BusinessException {
        PlayerEarning record = new PlayerEarning();
        record.setEarnPlayerId(playerId);
        record.setEarnInvestId(investId);
        return playerEarningMapper.getPlayerEarning(record);
    }

    @Override
    public PlayerEarning getPlayerEarnByPlayerIdReload(String playerId, Integer investId) {
        return playerEarningMapper.getPlayerEarningReload(playerId,investId);
    }

    @LcnTransaction
    @Transactional
    @Override
    public void add(PlayerEarning earning)throws BusinessException {
        playerEarningMapper.insertSelective(earning);
    }

    @LcnTransaction
    @Transactional
    @Override
    public void update(PlayerEarning playerEarning)throws BusinessException {
        playerEarning.setUpdateTime(new Date());
        playerEarningMapper.updateByPrimaryKeySelective(playerEarning);
    }

    @LcnTransaction
    @Transactional
    @Override
    public void addEarnLog(EarnIncomeLog earnIncomeLog)throws BusinessException {
        earnIncomeLogMapper.add(earnIncomeLog);
    }

    @LcnTransaction
    @Transactional
    @Override
    public List<PlayerEarning> getPlayerEarningByAfterHours(Integer withdrewState, Integer afterHours) {
        return playerEarningMapper.getPlayerEarningByAfterHours(withdrewState, afterHours);
    }

    @Override
    public List<PlayerEarning> getPlayerEarningCanFallDown(String time) {
        return playerEarningMapper.getPlayerEarningCanFallDown(time);
    }

    @Override
    public int updateEarningWithRawStatus(Integer earnId, Integer status) {
        return playerEarningMapper.updateEarningStatus(earnId,status);
    }

    @Override
    public int updateEarningFallDown(Integer earnId, BigDecimal amount) {
        return playerEarningMapper.updateFalldown(earnId,amount);
    }
    @Override
    public int updateCurrentAmount(Integer earnId,BigDecimal amount,Integer status,String playerId) {
        return playerEarningMapper.updateCurrentAmount(earnId,amount,status,playerId);
    }

}
