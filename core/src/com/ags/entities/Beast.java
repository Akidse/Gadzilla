package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AkidSe on 13.08.2017.
 */

public class Beast {

    Texture beastTexture;

    Sprite beastSprite;

    public Beast(Vector2 pPosition)
    {
        beastTexture = new Texture(Gdx.files.internal("beast.png"));

        beastSprite = new Sprite(beastTexture);
        beastSprite.setPosition(pPosition.x, pPosition.y);
    }

    public void render(float delta, SpriteBatch batch)
    {
        beastSprite.draw(batch);
    }

    public void dispose()
    {
        beastTexture.dispose();
    }
}
