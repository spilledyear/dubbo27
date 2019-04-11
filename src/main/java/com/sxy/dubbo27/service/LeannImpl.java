package com.sxy.dubbo27.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author spilledyear
 * @date 2019-04-10 23:53
 */
@Service
public class LeannImpl implements ILearn {
    @Override
    public void learn(String name) {
        System.out.println(name + "学习学习");
    }
}
