package com.pei.leetcode.util;

import java.math.BigDecimal;

public class BigInt {

    static String add(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toString();
    }

    static String subtract(String a, String b) {
        return new BigDecimal(a).subtract(new BigDecimal(b)).toString();
    }

    static String mod(String a, String b) {
        return new BigDecimal(a).divideAndRemainder(new BigDecimal(b))[1].toString();
    }
}
