package edu.java.deipss.base.util;

public class PageUtil {

    /**
     *
     * @param pageNum 页面大小 >=1
     * @param pageSize 页面大小 >=1
     * @return 页面的偏移
     */
    public static final int getPageOffset(int pageNum, int pageSize) {
        return (pageNum - 1) * pageSize;
    }
}
