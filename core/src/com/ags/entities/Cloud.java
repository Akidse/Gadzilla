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
        refreshSprite(true);
    }

    public void refreshSprite(boolean randomWidth)
    {
        int rand = random.nextInt(9)+1;
        cloudSprite.setPosition(-cloudSprite.getWidth(), Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*(rand/10.f));
        if(randomWidth)cloudSprite.setX(Gdx.graphics.getWidth()- Gdx.graphics.getWidth()*(rand/10.f));
        cloudSpeed = (4+random.nextInt(8))/10.f;
    }
    public void render(float delta, SpriteBatch batch)
    {
        cloudSprite.translateX(cloudSpeed);
        if(cloudSprite.getX() >= Gdx.graphics.getWidth())
        {
            refreshSprite(false);
        }
        cloudSprite.draw(batch);
    }

}
