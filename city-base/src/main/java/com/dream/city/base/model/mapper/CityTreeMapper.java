package com.dream.city.base.model.mapper;


import com.dream.city.base.model.entity.CityTree;
import com.dream.city.base.model.entity.RelationTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityTreeMapper {
    int deleteByPrimaryKey(Integer treeId);

    int insert(CityTree record);

    int insertSelective(CityTree record);

    CityTree selectByPrimaryKey(Integer treeId);

    int updateByPrimaryKeySelective(CityTree record);

    int updateByPrimaryKey(CityTree record);



    @Select("select * from city_tree where 1=1")
    List<CityTree> getCity();


    @Select("select * from city_tree where 1=1 and tree_parent_id = #{pid} and tree_player_id=#{cid}")
    RelationTree get(String pid,String cid);

    @Insert({"insert into `city_tree`(tree_parent_id, tree_player_id, tree_relation) values (#{parentId}, #{playerId}, #{relation})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void  saveTree(RelationTree tree);

    @Select("select * from city_tree where 1=1 limit 0,10")
    List<RelationTree> getTrees();

    @Update(" update city_tree set tree_parent_id=#{parentId},tree_player_id=#{playerId},tree_relation=#{relation},send_auto=#{sendAuto} where id = #{id}")
    void updateTree(RelationTree tree);



    @Select("select * from city_tree where 1=1 and tree_player_id=#{playerId} limit 1 ")
    RelationTree getByPlayer(String playerId);

    /**
     * 根据关系取玩家
     *
     * @param relation
     * @return
     */
    @Select("select * from city_tree where 1=1 and tree_relation=#{relation} limit 1 ")
    RelationTree getTreeByRef(String relation);

    @Select("select * from city_tree where 1=1 and tree_relation like  #{relation}")
    List<RelationTree> selectByRelation(String relation);


    @Select("select * from city_tree where 1=1 and tree_parent_id=#{parentId}")
    List<RelationTree> getChilds(String parentId);
}