package com.dream.city.domain.mapper;


import com.dream.city.base.model.entity.CityFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CityFile record);

    int insertSelective(CityFile record);

    CityFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CityFile record);

    int updateByPrimaryKey(CityFile record);
}