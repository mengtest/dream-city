package com.dream.city.base.model.req;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TradeVerifReq implements Serializable {

    private Integer earnId;

    private Integer verifyId;

    /** 交易id(交易记录表) */
    private Integer tradeId;

    private Integer orderId;

    /**  审核人id(员工表) */
    private Integer empId;

    /** 审核状态(待审核wait，审核中verifying，pass审核通过，notpass审核不通过)*/
    private String verifyStatus;

    /** 审核意见 */
    private String verifyDesc;

    /** 资金类型（usdt投资:usdt_invest，mt投资:mt_invest，转账:transfer，提现:withdraw,usdt投资收益:usdt_earnings,mt投资收益:mt_earnings,usdt投资税金:usdt_invest_tax） */
    private String amountType;


}