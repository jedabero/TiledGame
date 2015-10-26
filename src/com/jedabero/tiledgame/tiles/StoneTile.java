package com.jedabero.tiledgame.tiles;

import com.jedabero.tiledgame.gfx.Assets;

/**
 * StoneTile
 * Created by jedabero on 26/10/15.
 */
public class StoneTile extends Tile {
    public StoneTile(int id) {
        super(Assets.stone, id);
    }

    public boolean isSolid() {
        return true;
    }

}
