package com.dream.city.invest.service;

import com.dream.city.base.model.Result;
import com.dream.city.base.model.req.PlayerAccountReq;
import com.dream.city.base.model.req.TradeVerifReq;

/**
 *  玩家交易
 *  充值、提现、转账
 */
public interface PlayerTradeHandleService {

    /**
     * 玩家充值
     * @return
     */
    Result<Boolean> playerRecharge(PlayerAccountReq record);

    /**
     * 玩家提现
     * @return
     */
    Result<Boolean> playerWithdraw(PlayerAccountReq record);


    /**
     * 玩家转账
     * @return
     */
    Result<Boolean> playerTransfer(PlayerAccountReq record);


    /**
     * 提现、转账审核
     * @param record
     * @return
     */
    Result<Boolean> withdrawVerify(TradeVerifReq record);


}
