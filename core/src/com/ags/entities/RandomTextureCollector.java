package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AkidSe on 13.08.2017.
 */

public class RandomTextureCollector {

    ArrayList<Texture> textureList;

    Random random;

    public RandomTextureCollector()
    {
        random = new Random();
        textureList = new ArrayList<Texture>();
    }

    public void addTexture(Texture pTexture)
    {
        textureList.add(pTexture);
    }

    public Texture getRandomTexture()
    {
        int rand = random.nextInt(textureList.size());
        if(textureList.size() > 0)
        return textureList.get(rand);
        else return null;
    }

    public void dispose()
    {
        for (Texture texture: textureList)
        {
            texture.dispose();
        }
    }
}
