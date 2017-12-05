package com.common;

public enum DateFormat {

    StrikeDate("yyyy-MM-dd"),

    StrikeDateTime("yyyy-MM-dd HH:mm:ss");

    public String format;

    DateFormat(String format) {
        this.format = format;
    }
}
