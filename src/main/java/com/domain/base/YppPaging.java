package com.domain.base;

/**
 * Created by zhoufan on 2017/7/19.
 */
public class YppPaging {

    private Integer pages;

    private Integer size;

    private Integer start;


    private YppPaging(Integer pages, Integer size) {
        if (null == pages || pages < 0) {
            pages = 0;
        }
        if (null == size || size <= 0) {
            size = 20;
        }
        this.pages = pages;
        this.size = size;
    }

    public static YppPaging create(Integer pages, Integer size) {
        return new YppPaging(pages, size);
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEnd() {
        return size;
    }

    public int getStart() {
        return getSize() * getPages();
    }

    public void setStart(int start) {
        this.start = start;
    }
}
