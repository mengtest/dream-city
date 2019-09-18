package com.dream.city.service;

import com.dream.city.base.model.Result;
import com.dream.city.base.model.req.PageReq;
import com.dream.city.service.impl.FallBackPlayer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wvv
 */
@FeignClient(value = "city-player", fallback = FallBackPlayer.class)
public interface ConsumerPlayerService {

    @RequestMapping("/player/get/{playerId}")
    Result getPlayer(@PathVariable("playerId") String playerId);

    /**
     * 广场玩家列表
     * @param pageReq
     * @return
     */
    @RequestMapping("/player/getPlayers")
    Result getPlayers(@RequestBody PageReq pageReq);


    /**
     * 用户注册
     * @param jsonReq
     * @return
     */
    @RequestMapping("/player/reg")
    Result reg(@RequestBody String jsonReq);


    /**
     * 用户登录
     */
    @RequestMapping("/player/pwlogoin")
    Result pwLogoin(@RequestBody String jsonReq);


    /**
     * 用户登录
     */
    @RequestMapping("/player/codelogoin")
    Result codeLogoin(@RequestBody String jsonReq);


    /**
     * 用户退出
     */
    @RequestMapping("/player/quit")
    Result quit(@RequestParam("playerId") String playerId);


    /**
     * 用户忘记密码重置
     */
    @RequestMapping("/player/forgetPwd")
    Result forgetPwd(@RequestParam("username") String username,@RequestParam("oldPwd") String oldPwd);



    /**
     * 用户忘记密码重置
     */
    @RequestMapping("/player/resetLoginPwd")
    Result resetLoginPwd(@RequestParam("playerId") String playerId,
                         @RequestParam("oldPwd") String oldPwd,
                         @RequestParam("newPwd")  String newPwd);

    /**
     * 重置交易密码
     * @param playerId
     * @param oldPwd
     * @return
     */
    @RequestMapping("/player/resetTraderPwd")
    Result resetTraderPwd(@RequestParam("playerId") String playerId,
                          @RequestParam("oldPwd") String oldPwd,
                          @RequestParam("newPwd")  String newPwd);


    /**
     *
     * @return
     */
    @RequestMapping("/player/getPlayerByName")
    public Result getPlayerByName(@RequestBody String jsonReq);
}
