package com.ztf.boot.task.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SyncTaskTest {

    @Resource
    private SyncTask syncTask;

    @Test
    void testSyncTask() throws Exception{
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}