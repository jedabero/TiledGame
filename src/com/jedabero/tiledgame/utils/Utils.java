package com.jedabero.tiledgame.utils;

/**
 * Utils
 * Created by jedabero on 26/10/15.
 */
public class Utils {

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return 0;
        }
    }

}
