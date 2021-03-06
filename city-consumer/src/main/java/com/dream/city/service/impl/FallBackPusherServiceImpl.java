package com.dream.city.service.impl;

import com.dream.city.base.model.Message;
import com.dream.city.base.model.Result;
import com.dream.city.base.model.entity.Player;
import com.dream.city.service.consumer.ConsumerPusherService;
import org.springframework.stereotype.Component;

/**
 * @author Wvv
 */
@Component
public class FallBackPusherServiceImpl implements ConsumerPusherService {


    @Override
    public Result jobPush(Message message) {
        return null;
    }

    @Override
    public Result noticePush(Message message) {
        return null;
    }

}
