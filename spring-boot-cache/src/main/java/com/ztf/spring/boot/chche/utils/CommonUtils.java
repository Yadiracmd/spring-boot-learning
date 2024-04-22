package com.ztf.spring.boot.chche.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {

    public static int generateCode(){

        return ThreadLocalRandom.current().nextInt(1000,9999);

        //return 123456;
    }
}
