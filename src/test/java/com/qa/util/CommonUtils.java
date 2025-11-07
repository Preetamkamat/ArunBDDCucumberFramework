package com.qa.util;

import com.qa.base.Base;

public class CommonUtils extends Base {
    public static String generateEmailWithNanoTime() {
        long nanoTime = System.nanoTime();
        return "user_" + nanoTime + "@example.com";
    }
}
