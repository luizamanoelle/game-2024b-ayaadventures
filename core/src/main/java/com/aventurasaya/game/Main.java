package com.aventurasaya.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */

public class Main extends Game {

    static public final float WORLD_WIDTH = 1280;
    static public final float WORLD_HEIGHT = 720;
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);

        spriteBatch = new SpriteBatch();

        this.setScreen(new HomeScreen(this));

    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    @Override
    public void render() {
        camera.update();
        super.render();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }


}
