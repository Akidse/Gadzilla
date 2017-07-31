package com.ags.screens;

import com.ags.GadzillaGame;
import com.ags.entities.Cloud;
import com.ags.entities.ParallaxCloudBackground;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by AkidSe on 23.07.2017.
 */

public class MenuScreen implements Screen {
    final GadzillaGame game;

    Texture cloudTexture;
    ParallaxCloudBackground parallaxCloudBackground;
    public MenuScreen(final GadzillaGame pGame)
    {
        game = pGame;
        parallaxCloudBackground = new ParallaxCloudBackground();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.62f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        parallaxCloudBackground.render(delta, game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
