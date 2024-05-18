package com.ztf.boot.task.task;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@Slf4j
public abstract class AbstractTask {
    public void doTaskOne() throws Exception {
        log.info("开始做任务一！");
        long startTime = currentTimeMillis();
        sleep(3000);
        long endTime = currentTimeMillis();
        log.info("完成任务一耗时: {}", endTime - startTime);
    }

    public void doTaskTwo() throws Exception {
        log.info("开始做任务二！");
        long startTime = currentTimeMillis();
        sleep(4000);
        long endTime = currentTimeMillis();
        log.info("完成任务二耗时: {}", endTime - startTime);
    }

    public void doTaskThree() throws Exception {
        log.info("开始做任务三！");
        long startTime = currentTimeMillis();
        sleep(5000);
        long endTime = currentTimeMillis();
        log.info("完成任务三耗时: {}", endTime - startTime);
    }

}
