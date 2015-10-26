package com.jedabero.tiledgame.gfx;

import java.awt.image.BufferedImage;

/**
 * Assets
 * Created by jedabero on 25/10/15.
 */
public class Assets {

    public static BufferedImage player1, player2, dirt, grass, stone, tree;

    private static final int width = 32, height = 32;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        player1 = sheet.crop(0, 0, width, height);
        player2 = sheet.crop(width, 0, width, height);
        dirt = sheet.crop(width * 2, 0, width, height);
        grass = sheet.crop(width * 3, 0, width, height);
        stone = sheet.crop(width * 4, 0, width, height);
        tree = sheet.crop(width * 5, 0, width, height);
    }

}
