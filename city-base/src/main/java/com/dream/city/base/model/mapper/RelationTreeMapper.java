package com.dream.city.base.model.mapper;


import com.dream.city.base.model.entity.InvestRule;
import com.dream.city.base.model.entity.RelationTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wvv
 */
@Mapper
public interface RelationTreeMapper {
    int deleteByPrimaryKey(Integer treeId);

    int insert(RelationTree record);

    int insertSelective(RelationTree record);

    RelationTree selectByPrimaryKey(Integer treeId);

    int updateByPrimaryKeySelective(RelationTree record);

    int updateByPrimaryKey(RelationTree record);

    RelationTree getByPlayer(@Param("treePlayerId") String treePlayerId);

    @Results(id = "treeBaseMap", value = {
            @Result(property = "treeId", column = "tree_id", id = true),
            @Result(property = "treeParentId", column = "tree_parent_id"),
            @Result(property = "treePlayerId", column = "tree_player_id"),
            @Result(property = "treeRelation", column = "tree_relation"),
            @Result(property = "sendAuto", column = "send_auto"),
            @Result(property = "treeLevel", column = "tree_level"),
            @Result(property = "treeChilds", column = "tree_childs"),
            @Result(property = "treeGrandson", column = "tree_grandson"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    @Select({"select * from `city_tree` where 1=1 and tree_id = #{treeId}"})
    RelationTree getRuleById(@Param("treeId") String treeId);


    @Select("select * from city_tree where 1=1")
    List<RelationTree> getCity();

    @Select("select * from city_tree where 1=1 and tree_parent_id = #{pid} and tree_player_id=#{cid}")
    RelationTree get(@Param("pid") String pid, @Param("cid") String cid);

    @Insert({"insert into `city_tree`(tree_id,tree_parent_id," +
            " tree_player_id, tree_relation,send_auto,tree_level," +
            " tree_childs, tree_grandson, " +
            " create_time) " +
            " values (#{treeId},#{treeParentId}, #{treePlayerId}, " +
            " #{treeRelation},#{sendAuto},#{treeLevel}," +
            " #{treeChilds}," +
            " #{ treeGrandson}," +
            " #{createTime})"})
        //@Options(useGeneratedKeys = true, keyProperty = "tree_id")
    void saveTree(RelationTree tree);

    @Select("select * from city_tree where 1=1 limit 0,10")
    List<RelationTree> getTrees();

    @Update(" update city_tree set tree_parent_id=#{treeParentId}," +
            " tree_player_id=#{treePlayerId},tree_relation=#{treeRelation}," +
            " tree_childs=#{treeChilds},tree_grandson=#{treeGrandson}," +
            " send_auto=#{sendAuto},tree_level=#{treeLevel}, " +
            " tree_childs =#{treeChilds}," +
            " tree_grandson=#{ treeGrandson} " +
            " where 1=1 and tree_id = #{treeId}")
    void updateTree(RelationTree tree);

    /**
     * 根据关系取玩家
     *
     * @param relation
     * @return
     */
    @Select("select " +
            " tree_id treeId,tree_parent_id treeParentId, " +
            " tree_player_id treePlayerId," +
            " tree_relation treeRelation," +
            " send_auto sendAuto," +
            " tree_level treeLevel," +
            " tree_childs treeChilds," +
            " tree_grandson treeGrandson," +
            " create_time createTime " +
            " from city_tree where 1=1 and tree_relation=#{relation} limit 1 ")
    RelationTree getTreeByRef(@Param("relation") String relation);

    @Select("select " +
            " tree_id treeId," +
            " tree_parent_id treeParentId, " +
            " tree_player_id treePlayerId," +
            " tree_relation treeRelation," +
            " send_auto sendAuto," +
            " tree_level treeLevel," +
            " tree_childs treeChilds," +
            " tree_grandson treeGrandson," +
            " create_time createTime " +
            " from city_tree where 1=1 and tree_relation like  #{relation}")
    List<RelationTree> selectByRelation(@Param("relation") String relation);


    @Select("select * from city_tree where 1=1 and tree_parent_id=#{parentId}")
    List<RelationTree> getChilds(@Param("parentId") String parentId);

    @Select("select " +
            " tree_id treeId," +
            " tree_parent_id treeParentId, " +
            " tree_player_id treePlayerId," +
            " tree_relation treeRelation," +
            " send_auto sendAuto," +
            " tree_level treeLevel," +
            " tree_childs treeChilds," +
            " tree_grandson treeGrandson," +
            " create_time createTime " +
            " from city_tree where 1=1 and tree_player_id=#{playerId}  ORDER BY create_time DESC LIMIT 1")
    RelationTree getTreeByPlayerId(@Param("playerId") String playerId);



    @Select("select count(0) from city_tree as ct,city_player as cp where ct.tree_player_id = cp.player_id and tree_relation like concat(#{tree},'/%') and cp.create_time BETWEEN #{startTime} AND #{endTime}")
    Integer getTeamListCount(@Param("tree")String tree,@Param("startTime")String startTime,@Param("endTime")String endTime);

    @Select("select * from city_tree where tree_player_id=#{playerId}")
    @ResultMap("treeBaseMap")
    RelationTree getSelfTree(@Param("playerId") String playerId);

}