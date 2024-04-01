package com.ztf.boot.log.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
//        LOGGER.trace("Trace 日志...");
//        LOGGER.debug("Debug日志...");
//        LOGGER.info("Info日志...");
//        LOGGER.warn("Warn日志...");
//        LOGGER.error("Error日志...");
        Logger myLogger = LoggerFactory.getLogger("myLogger");
        myLogger.info("hello world");
    }

}
