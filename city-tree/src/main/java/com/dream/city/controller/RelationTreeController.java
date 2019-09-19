package com.dream.city.controller;

import com.dream.city.base.model.CityGlobal;
import com.dream.city.base.model.Result;
import com.dream.city.domain.entity.RelationTree;
import com.dream.city.domain.entity.User;
import com.dream.city.service.RelationTreeService;
import com.dream.city.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/tree")
public class RelationTreeController {

    @Autowired
    private RelationTreeService relationTreeService;

    /**
     * 根据玩家ID查找关系
     *
     * @param playerId
     * @return
     */
    @RequestMapping("/get/tree")
    public Result get(@RequestParam("playerId") String playerId) {
        RelationTree tree = relationTreeService.getByPlayer(playerId);
        Result result = new Result();
        return new Result(CityGlobal.Constant.TREE_RELATION_SUCCESS, 200, tree);
    }

    /**
     * 添加玩家关系
     *
     * @param parentId
     * @param playerId
     * @param invite
     * @return
     */
    @RequestMapping("/add/tree")
    public Result add(@RequestParam("parentId") String parentId, @RequestParam("playerId") String playerId, @RequestParam("invite") String invite) {
        Result result = relationTreeService.save(parentId, playerId, invite);

        return result;
    }

    /**
     * 从上级查找playerId以下n级
     *
     * @param level
     * @return
     */
    @RequestMapping("/find/Level")
    public Result findByLevel(@RequestParam("playerId") String playerId, @RequestParam("level") Integer level) {
        Map<Integer, List<RelationTree>> treeMap = new Hashtable<>();

        treeMap = relationTreeService.getLevelChildTreesMap(playerId,level);

        return new Result("success",200,treeMap);
    }

    /**
     *
     * @param playerId
     * @return
     */
    @RequestMapping("/find/parent")
    public Result findParent(@RequestParam("playerId")String playerId){
        return new Result("success",200,relationTreeService.getParent(playerId));
    }


}