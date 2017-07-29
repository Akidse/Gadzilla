package com.ags.screens;

import com.ags.GadzillaGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by AkidSe on 23.07.2017.
 */

public class IntroScreen implements Screen {
    final GadzillaGame game;

    Texture logoTexture;
    Sprite logoSprite;
    OrthographicCamera camera;

    long startTime;

    public IntroScreen(final GadzillaGame pGame)
    {
        game = pGame;
        logoTexture = new Texture(Gdx.files.internal("ags_logo.png"));
        logoTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        logoSprite = new Sprite(logoTexture);
        logoSprite.setSize(Gdx.graphics.getWidth()/4.f, Gdx.graphics.getWidth()/4.f);
        logoSprite.setPosition((Gdx.graphics.getWidth() - logoSprite.getWidth())/2.f, (Gdx.graphics.getHeight() - logoSprite.getHeight())/2.f);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);

        startTime = TimeUtils.millis();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.216f, 0.698f, 0.655f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        logoSprite.draw(game.batch);
        game.batch.end();
        if (TimeUtils.millis() - startTime > 5000) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }
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
        logoTexture.dispose();
    }
}
