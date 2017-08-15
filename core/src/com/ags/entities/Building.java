package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AkidSe on 13.08.2017.
 */

public class Building extends GameBlock {

    RandomTextureCollector randomTextureCollector;

    Sprite buildingSprite;

    public Building(RandomTextureCollector pRandomTextureCollector, float pX)
    {
        randomTextureCollector = pRandomTextureCollector;

        buildingSprite = new Sprite(randomTextureCollector.getRandomTexture());

        buildingSprite.setPosition(pX, Gdx.graphics.getHeight()*0.2f);

        buildingSprite.setSize(GameBlock.BLOCK_WIDTH, buildingSprite.getTexture().getHeight()*(GameBlock.BLOCK_WIDTH/buildingSprite.getTexture().getWidth()));
    }

    public void render(float delta, SpriteBatch batch)
    {
        buildingSprite.translateX(-120.f*delta);
        buildingSprite.draw(batch);
    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(buildingSprite.getX(), buildingSprite.getY());
    }

}
