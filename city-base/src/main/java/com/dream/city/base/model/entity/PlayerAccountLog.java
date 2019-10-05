package com.dream.city.base.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Wvv
 */
@Data
public class PlayerAccountLog implements Serializable {
    private Long id;

    private String playerId;

    private String address;

    private BigDecimal amountMt;
    private BigDecimal amountUsdt;
    private int type;
    private String desc;
    private Date createTime;
}