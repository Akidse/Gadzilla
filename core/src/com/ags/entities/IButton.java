package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by AkidSe on 07.08.2017.
 */

public class IButton {

    private Sprite button;
    public IButton(Texture pTexture)
    {
        button = new Sprite(pTexture);
    }

    public void setSize(float xSize, float ySize)
    {
        button.setSize(xSize, ySize);
    }

    public void setPosition(float xPosition, float yPosition)
    {
        button.setPosition(xPosition, yPosition);
    }

    public void setScale(float pScale)
    {
        button.setScale(pScale);
    }

    public float getY()
    {
        return button.getY();
    }

    public float getX()
    {
        return button.getX();
    }

    public float getWidth()
    {
        return button.getWidth();
    }

    public float getHeight()
    {
        return button.getHeight();
    }

    public boolean isClicked(float x, float y)
    {
        if(x >= button.getX() && x <= button.getX() + button.getWidth()
                && y >= button.getY() && y <= button.getHeight())return true;
        return false;
    }

    public void render(SpriteBatch batch)
    {
        button.draw(batch);
    }

}
