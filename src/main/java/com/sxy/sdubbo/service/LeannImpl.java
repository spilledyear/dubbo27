package com.sxy.sdubbo.service;

import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author spilledyear
 * @date 2019-04-10 23:53
 */
@Service
public class LeannImpl implements ILearn {
    @Override
    public String learn(String name) {
        return "学习： " + name;
    }


    @Override
    public CompletableFuture<String> asyncLearn(String name) {
        return CompletableFuture.supplyAsync(() -> "异步学习： " + name);
    }
}
