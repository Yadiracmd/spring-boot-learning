package com.ztf.boot.task.job;

import com.ztf.boot.task.utils.CreateUtils;
import jakarta.annotation.Resource;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class QuartzSimpleTask extends QuartzJobBean {

    @Resource
    private CreateUtils createUtils;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行备份任务");
        createUtils.get();
    }
}