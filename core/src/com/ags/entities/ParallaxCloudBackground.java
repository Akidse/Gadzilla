package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by AkidSe on 31.07.2017.
 */

public class ParallaxCloudBackground {
    Cloud[] clouds;
    Texture[] cloudTexture;
    public ParallaxCloudBackground()
    {
        cloudTexture = new Texture[4];
        clouds = new Cloud[4];

        for(int i = 0; i < 4; i++)
        {
            cloudTexture[i] = new Texture(Gdx.files.internal("menu_cloud_"+(i+1)+".png"));
            clouds[i] = new Cloud(cloudTexture[i]);
        }
    }
    public void render(float delta, SpriteBatch batch)
    {
        for(int i = 0; i < 4; i++)
        {
            clouds[i].render(delta, batch);
        }
    }
}
