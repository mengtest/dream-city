package com.dream.city.service.impl;

import com.dream.city.base.model.entity.RelationTree;
import com.dream.city.service.RelationTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Wvv
 */

@Service
public class RelationTreeServiceImpl implements RelationTreeService {

    @Override
    public int getMembersIncrement(String orderPayerId, Date date) {
        Map<Integer, List<RelationTree>> trees = getLevelChildTreesMap(orderPayerId, 9);

        List<RelationTree> relationTrees = new ArrayList<>();
        trees.forEach((key, tree) -> {
            tree.forEach((t) -> {
                try {


                    /**
                     *TODO
                     *  在今天截止预约之前 && 并且 && 在昨天预约开始之后
                     */
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //时分格式
                    SimpleDateFormat df1 = new SimpleDateFormat("HH:mm");
                    //年月日格式
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = df1.format(date);
                    String dateToday = dt.format(new Date());
                    String end = dateToday + " " + date1;
                    Date endTime = df.parse(end);

                    System.out.println(date1);
                    System.out.println(dateToday);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, -1);
                    String yesterday = dt.format(cal.getTime());
                    String start = yesterday + " " + date1;


                    System.out.println(end);
                    System.out.println(start);

                    Date startTime = df.parse(start);
                    if (t.getCreateTime().after(startTime) && t.getCreateTime().before(endTime)) {
                        relationTrees.add(t);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        });

        return relationTrees.size();
    }

    /**
     * 找出指定层级数量的所有子对象
     *
     * @param playerId
     * @param level
     * @return
     */
    @Override
    public Map<Integer, List<RelationTree>> getLevelChildTreesMap(String playerId, int level) {
        Map<Integer, List<RelationTree>> treeListMap = new Hashtable<>();
        for (int i = 0; i < level; i++) {
            List<RelationTree> levelTree = this.findLevel(playerId, i + 1);
            treeListMap.put(i + 1, levelTree);
        }

        return treeListMap;
    }

    @Override
    public List<RelationTree> findLevel(String playerId, int level) {
        return null;
    }
}
