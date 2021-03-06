package com.dream.city.base.model.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PlayerLikesReq implements Serializable {

    private Integer likedId;

    private Integer logId;

    //收获点赞玩家ID
    private String likedPlayerId;
    private String friendName;
    private String friendNick;

    //点赞玩家ID
    private String likePlayerId;
    private String playerName;
    private String playerNick;

    private Integer likedInvestId;
    private String inName;

    private Integer likedGetTotal;
    private Integer likedSetTotal;

    private Date createTime;
    private Date updateTime;

}