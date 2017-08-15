package com.ags.screens;

import com.ags.GadzillaGame;
import com.ags.entities.Beast;
import com.ags.entities.Building;
import com.ags.entities.GameBlock;
import com.ags.entities.Plane;
import com.ags.entities.RandomTextureCollector;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by AkidSe on 13.08.2017.
 */

public class GameScreen implements Screen
{

    GadzillaGame game;

    Beast beast;

    RandomTextureCollector buildingRTC;
    RandomTextureCollector planeRTC;

    Random random;

    GameBlock[] gameBlocks;
    int lastBlock;

    public GameScreen(GadzillaGame pGame)
    {
        game = pGame;

        beast = new Beast(new Vector2(0.f, Gdx.graphics.getHeight()*0.2f));

        random = new Random();

        buildingRTC = new RandomTextureCollector();

        buildingRTC.addTexture(new Texture(Gdx.files.internal("building_1.png")));
        buildingRTC.addTexture(new Texture(Gdx.files.internal("building_2.png")));
        buildingRTC.addTexture(new Texture(Gdx.files.internal("building_3.png")));

        planeRTC = new RandomTextureCollector();

        planeRTC.addTexture(new Texture(Gdx.files.internal("plane_1.png")));

        gameBlocks = new GameBlock[6];
        float blockX = Gdx.graphics.getWidth();
        int randomNumber;
        for(int i = 0; i < 6; i++)
        {
            randomNumber = random.nextInt(2);
            switch(randomNumber)
            {
                case 0:
                    gameBlocks[i] = new Building(buildingRTC, blockX);
                    break;
                case 1:
                    gameBlocks[i] = new Plane(planeRTC, blockX);
                    break;
            }

            blockX += GameBlock.BLOCK_WIDTH + GameBlock.BLOCK_DISTANCE;

            lastBlock = i;
        }
    }

    public GameBlock generateBlock(float pBlockX)
    {
        float blockX = pBlockX + GameBlock.BLOCK_WIDTH + GameBlock.BLOCK_DISTANCE;
        int randomNumber;
        randomNumber = random.nextInt(2);
        switch(randomNumber)
        {
            case 0:
                return new Building(buildingRTC, blockX);
            case 1:
                return new Plane(planeRTC, blockX);
        }
        
        return null;
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(Color.BLUE);
        game.shapeRenderer.rect(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.shapeRenderer.setColor(Color.GREEN);
        game.shapeRenderer.rect(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()*0.2f);
        game.shapeRenderer.end();

        game.batch.begin();
        beast.render(delta, game.batch);
        for(int i = 0; i < 6; i++)
        {
            gameBlocks[i].render(delta, game.batch);
            if(gameBlocks[i].getPosition().x <= 300)
            {
                gameBlocks[i] = generateBlock(gameBlocks[lastBlock].getPosition().x);
                lastBlock = i;
            }
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        beast.dispose();
    }
}
