package ru.cb.demo.utils;

import java.util.Date;

public class CurentTime {

    public static long getCurentTime() {
        Date date = new Date();
        return date.getTime();
    }
}
