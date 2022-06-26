package edu.java.deipss.base.util;

public class PageUtil {

    public static final int getPageOffset(int pageNum, int pageSize) {
        return (pageNum - 1) * pageSize;
    }
}
