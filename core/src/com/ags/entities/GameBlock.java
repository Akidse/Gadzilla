package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AkidSe on 15.08.2017.
 */

public abstract class GameBlock {

    public static final float BLOCK_WIDTH = Gdx.graphics.getWidth() / 8;
    public static final float BLOCK_DISTANCE = Gdx.graphics.getWidth() / 16;

    public abstract void render(float delta, SpriteBatch batch);

    public abstract Vector2 getPosition();
}
