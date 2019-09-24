package com.sxy.sdubbo.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author spilledyear
 * @date 2019-04-10 23:53
 */
public interface ILearn {
    String learn(String name);

    /**
     * 服务端异步
     *
     * @param name
     * @return
     */
    CompletableFuture<String> asyncLearn(String name);

}
