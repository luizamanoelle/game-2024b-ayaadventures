package com.aventurasaya.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {

    private final Main game;
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;


    private Texture backGround;

    public GameScreen(Main game) {
        this.game = game;

        this.camera = game.getCamera();
        this.spriteBatch = game.getSpriteBatch();
        this.backGround = new Texture("Game_Background.png");
        this.shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        spriteBatch.setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();
        game.getSpriteBatch().draw(backGround, 0, 0, Main.WORLD_WIDTH, Main.WORLD_HEIGHT);
        game.getSpriteBatch().end();

        // Desenha a cor fixa com um espaço nas laterais
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Define a cor (RGBA)
        shapeRenderer.setColor(0.96f, 0.84f, 0.56f, 1f);

        // Desenha o retângulo centralizado com espaços nas laterais
        float espacoLaterais = 100; // Espaço das laterais
        shapeRenderer.rect(espacoLaterais, 0, Main.WORLD_WIDTH - 2 * espacoLaterais, Main.WORLD_HEIGHT);

        shapeRenderer.end();
    }


    @Override
    public void dispose() {
      backGround.dispose();
      shapeRenderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Main.WORLD_WIDTH, Main.WORLD_HEIGHT);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

}


