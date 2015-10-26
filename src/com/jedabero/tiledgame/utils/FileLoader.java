package com.jedabero.tiledgame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileLoader
 * Created by jedabero on 26/10/15.
 */
public class FileLoader {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            bufferedReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return builder.toString();
    }

}
