package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by AkidSe on 30.07.2017.
 */

public class Cloud {
    Texture cloudTexture;
    Sprite cloudSprite;
    float cloudSpeed;

    final Random random = new Random();

    public Cloud(Texture pCloudTexture)
    {
        cloudTexture = pCloudTexture;
        cloudSprite = new Sprite(cloudTexture);
        cloudSprite.setScale(1f);
        refreshSprite();
    }

    public void refreshSprite()
    {
        cloudSprite.setPosition(-cloudSprite.getWidth(), (Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*((random.nextInt(9))/10.f)));
        cloudSpeed = (3+(float)random.nextInt(4))/10.f;
    }
    public void render(float delta, SpriteBatch batch)
    {
        cloudSprite.translateX(cloudSpeed);
        if(cloudSprite.getX() >= Gdx.graphics.getWidth())
        {
            refreshSprite();
        }
        cloudSprite.draw(batch);
    }

}
