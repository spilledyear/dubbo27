package com.sxy.sdubbo.consumer;

import com.sxy.sdubbo.service.ILearn;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author spilledyear
 * @date 2019/9/23 20:57
 */
@Service
public class ConsumerService {

    @Reference
    private ILearn learn;


    public void asyncTest() {
        CompletableFuture<String> future = learn.asyncLearn("语文");

        future.whenComplete((v, e) -> {
            if (e != null) {
                System.out.println("异常 " + e);
            } else {
                System.out.println(v);
            }
        });
    }
}
