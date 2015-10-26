package com.jedabero.tiledgame.gfx;

import java.awt.image.BufferedImage;

/**
 * SpriteSheet
 * Created by jedabero on 25/10/15.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
