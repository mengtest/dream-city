package com.dream.city.base.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Wvv
 */
@Data
public class SalesOrder {
    private Integer id;
    private String orderId;
    private BigDecimal orderAmount;
    private String orderBuyType;
    private String orderPayType;
    private String orderPlayerBuyer;
    private String orderPlayerSeller;
    private int orderState;
    private Timestamp createTime;
    private Timestamp updateTime;
}