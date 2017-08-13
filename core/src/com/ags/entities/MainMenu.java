package com.ags.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

/**
 * Created by AkidSe on 07.08.2017.
 */

public class MainMenu {

    float MENU_SIZE = 0.5f;

    Texture topLeftButtonTexture;
    Texture topRightButtonTexture;
    Texture bottomLeftButtonTexture;
    Texture bottomRightButtonTexture;
    Texture centerButtonTexture;
    Texture bottomButtonTexture;
    IButton topLeftButton;
    IButton topRightButton;
    IButton bottomLeftButton;
    IButton bottomRightButton;
    IButton centerButton;
    IButton bottomButton;
    public MainMenu()
    {
        float menuScaleSize = 4.5f;
        float padding;
        topLeftButtonTexture = new Texture(Gdx.files.internal("menu_top_left_button.png"));
        topRightButtonTexture = new Texture(Gdx.files.internal("menu_top_right_button.png"));
        bottomLeftButtonTexture = new Texture(Gdx.files.internal("menu_bottom_left_button.png"));
        bottomRightButtonTexture = new Texture(Gdx.files.internal("menu_bottom_right_button.png"));
        centerButtonTexture = new Texture(Gdx.files.internal("menu_center_button.png"));
        bottomButtonTexture = new Texture(Gdx.files.internal("menu_bottom_button.png"));

        topLeftButton = new IButton(topLeftButtonTexture);
        topLeftButton.setSize(topLeftButtonTexture.getWidth()*menuScaleSize, topLeftButtonTexture.getHeight()*menuScaleSize);
        topLeftButton.setPosition(81, Gdx.graphics.getHeight() - 300);

        padding = topLeftButton.getHeight()/6.f;

        bottomLeftButton = new IButton(bottomLeftButtonTexture);
        bottomLeftButton.setSize(bottomLeftButtonTexture.getWidth()*menuScaleSize, bottomLeftButtonTexture.getHeight()*menuScaleSize);
        bottomLeftButton.setPosition(topLeftButton.getX() + topLeftButton.getWidth() - bottomLeftButton.getWidth(), topLeftButton.getY() - topLeftButton.getHeight());

        centerButton = new IButton(centerButtonTexture);
        centerButton.setSize(centerButtonTexture.getWidth()*menuScaleSize, centerButtonTexture.getHeight()*menuScaleSize);
        centerButton.setPosition(topLeftButton.getX() + topLeftButton.getWidth() + padding, bottomLeftButton.getY() - padding);

        topRightButton = new IButton(topRightButtonTexture);
        topRightButton.setSize(topRightButtonTexture.getWidth()*menuScaleSize, topRightButtonTexture.getHeight()*menuScaleSize);
        topRightButton.setPosition(centerButton.getX() + centerButton.getWidth() + padding, topLeftButton.getY());

        bottomRightButton = new IButton(bottomRightButtonTexture);
        bottomRightButton.setSize(bottomRightButtonTexture.getWidth()*menuScaleSize, bottomRightButtonTexture.getHeight()*menuScaleSize);
        bottomRightButton.setPosition(topRightButton.getX(), bottomLeftButton.getY());

        bottomButton = new IButton(bottomButtonTexture);
        bottomButton.setSize(bottomButtonTexture.getWidth()*menuScaleSize, bottomButtonTexture.getHeight()*menuScaleSize);
        bottomButton.setPosition(centerButton.getX(), centerButton.getY() - bottomButton.getHeight() - padding);
    }


    public void render(SpriteBatch batch, float delta)
    {
        topLeftButton.render(batch);
        bottomLeftButton.render(batch);
        centerButton.render(batch);
        topRightButton.render(batch);
        bottomRightButton.render(batch);
        bottomButton.render(batch);
    }

    public String isClicked(float x, float y)
    {
        if(topLeftButton.isClicked(x, y))return "top_left";
        if(bottomLeftButton.isClicked(x, y))return "bottom_left";
        if(centerButton.isClicked(x, y))return "center";
        if(topRightButton.isClicked(x, y))return "top_right";
        if(bottomRightButton.isClicked(x, y))return "bottom_right";
        if(bottomButton.isClicked(x, y))return "bottom";
        return "none";
    }

}
