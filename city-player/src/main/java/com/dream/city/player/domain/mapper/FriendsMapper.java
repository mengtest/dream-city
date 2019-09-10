package com.dream.city.player.domain.mapper;


import com.dream.city.player.domain.entity.Friends;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
}