package edu.java.deipss.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

    public static long divide(long a,long b){
        return a/b;
    }

    public static BigDecimal divideHalfUp(BigDecimal a, BigDecimal b){
        return a.divide(b,2, RoundingMode.HALF_UP);
    }
    public static BigDecimal divideHalfUp(Long a, Long b){
        return new BigDecimal(a).divide(new BigDecimal(b),2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divideHalfUp(Integer a, Integer b){
        return new BigDecimal(a).divide(new BigDecimal(b),2, RoundingMode.HALF_UP);
    }



}
