package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AkidSe on 14.08.2017.
 */

public class Plane extends GameBlock {

    RandomTextureCollector randomTextureCollector;

    Sprite planeSprite;

    public Plane(RandomTextureCollector pRandomTextureCollector, float pX)
    {
        randomTextureCollector = pRandomTextureCollector;

        planeSprite = new Sprite(randomTextureCollector.getRandomTexture());

        planeSprite.setPosition(pX, Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*0.2f);


        planeSprite.setSize(GameBlock.BLOCK_WIDTH, planeSprite.getTexture().getHeight()*(GameBlock.BLOCK_WIDTH/planeSprite.getTexture().getWidth()));
    }

    public void render(float delta, SpriteBatch batch)
    {
        planeSprite.translateX(-120.f*delta);
        planeSprite.draw(batch);
    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(planeSprite.getX(), planeSprite.getY());
    }

}
